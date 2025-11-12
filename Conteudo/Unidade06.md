# Aula 23 – Persistência de Dados em Arquivos (Binários e Texto - CSV)

## 1. Introdução à Persistência de Dados

A **persistência de dados** é o processo de **armazenar informações de forma permanente**, mesmo após o término da execução de um programa.  
Antes de usar bancos de dados, uma forma comum de persistência é o uso de **arquivos**.

O Java fornece diversas classes no pacote `java.io` para lidar com arquivos texto e binários.

---

## 2. Manipulação de Arquivos com a Classe `File`

A classe `File` representa um **arquivo ou diretório** no sistema operacional.  
Com ela, podemos verificar a existência, tamanho, caminho e criar ou excluir arquivos.

```java
import java.io.File;
import java.io.IOException;

public class ExemploFile {
    public static void main(String[] args) throws IOException {
        File arquivo = new File("dados.txt");

        if (!arquivo.exists()) {
            arquivo.createNewFile();
            System.out.println("Arquivo criado com sucesso!");
        }

        System.out.println("Caminho: " + arquivo.getAbsolutePath());
        System.out.println("Tamanho: " + arquivo.length() + " bytes");
    }
}
```

---

## 3. Arquivos Binários

Arquivos **binários** armazenam os dados no formato original da linguagem de máquina,
sem conversão para texto legível.
São mais **eficientes** e evitam perda de precisão em números ou caracteres especiais.

---

### 3.1 `FileOutputStream` e `FileInputStream`

Essas classes permitem **gravar** e **ler** bytes diretamente em um arquivo.

```java
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ExemploBinario {
    public static void main(String[] args) throws IOException {
        // Escrita de bytes
        FileOutputStream out = new FileOutputStream("arquivo.bin");
        out.write(65); // escreve o caractere 'A'
        out.write(66); // escreve o caractere 'B'
        out.close();

        // Leitura de bytes
        FileInputStream in = new FileInputStream("arquivo.bin");
        int dado;
        while ((dado = in.read()) != -1) {
            System.out.print((char) dado); // imprime AB
        }
        in.close();
    }
}
```

---

### 3.2 `DataOutputStream` e `DataInputStream`

Permitem gravar **tipos primitivos** (int, double, boolean, etc.) e `String` de forma estruturada.

```java
import java.io.*;

public class ExemploDataStream {
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream("dados.bin"));
        out.writeInt(123);
        out.writeDouble(45.6);
        out.writeUTF("Olá, mundo!");
        out.close();

        DataInputStream in = new DataInputStream(new FileInputStream("dados.bin"));
        System.out.println(in.readInt());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        in.close();
    }
}
```

---

### 3.3 `ObjectOutputStream` e `ObjectInputStream`

Usadas para **serializar** objetos — ou seja, converter um objeto em bytes para armazenar em arquivo.
O objeto deve implementar a interface `Serializable`.

```java
import java.io.*;

class Pessoa implements Serializable {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return nome + " (" + idade + " anos)";
    }
}

public class ExemploObjeto {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Pessoa p = new Pessoa("Ana", 30);

        // Gravar objeto
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pessoa.dat"));
        out.writeObject(p);
        out.close();

        // Ler objeto
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("pessoa.dat"));
        Pessoa recuperada = (Pessoa) in.readObject();
        in.close();

        System.out.println("Objeto lido: " + recuperada);
    }
}
```

- **Observação:**
A serialização grava os dados de forma binária, e a leitura deve respeitar o mesmo tipo e ordem.

---

## 4. Persistência em Arquivos Texto (CSV)

Os arquivos **CSV (Comma-Separated Values)** armazenam dados em formato **texto**,
onde cada linha representa um registro e cada campo é separado por vírgulas (ou ponto e vírgula).

Exemplo de conteúdo:

```
1;Ana;30
2;Carlos;25
3;Beatriz;40
```

---

### 4.1 Gerando o CSV com `PrintWriter`

Cada objeto pode ter um método que retorna seus dados formatados para o arquivo CSV.
Em seguida, podemos gravar todos os objetos em um arquivo de forma simples.

```java
import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

class Pessoa {
    private int id;
    private String nome;
    private int idade;

    public Pessoa(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public String toCSV() {
        return id + ";" + nome + ";" + idade;
    }
}

public class GravarCSV {
    public static void main(String[] args) throws IOException {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa(1, "Ana", 30));
        pessoas.add(new Pessoa(2, "Carlos", 25));

        try (PrintWriter writer = new PrintWriter("pessoas.csv")) {
            for (Pessoa p : pessoas) {
                writer.println(p.toCSV());
            }
        }

        System.out.println("Arquivo CSV gerado com sucesso!");
    }
}
```

---

### 4.2 Lendo o CSV e Convertendo em Objetos

Podemos ler o arquivo linha por linha e recriar os objetos originais.

```java
import java.io.*;
import java.util.*;

public class LerCSV {
    public static void main(String[] args) throws IOException {
        List<Pessoa> pessoas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("pessoas.csv"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";");
                int id = Integer.parseInt(campos[0]);
                String nome = campos[1];
                int idade = Integer.parseInt(campos[2]);
                pessoas.add(new Pessoa(id, nome, idade));
            }
        }

        pessoas.forEach(System.out::println);
    }
}
```

- O uso de `Stream` também pode simplificar a leitura:

```java
List<Pessoa> pessoas = Files.lines(Paths.get("pessoas.csv"))
    .map(linha -> linha.split(";"))
    .map(campos -> new Pessoa(
        Integer.parseInt(campos[0]),
        campos[1],
        Integer.parseInt(campos[2])
    ))
    .toList();
```

---

## 5. Comparativo: Binário x CSV

| Critério                  | Binário                     | CSV                               |
| ------------------------- | --------------------------- | --------------------------------- |
| **Formato**               | Não legível                 | Legível (texto)                   |
| **Tamanho do arquivo**    | Menor                       | Maior                             |
| **Velocidade de leitura** | Mais rápida                 | Mais lenta                        |
| **Compatibilidade**       | Apenas Java                 | Qualquer aplicativo (Excel, etc.) |
| **Uso recomendado**       | Armazenar objetos complexos | Exportar ou importar dados        |

---

## 6. Resumo da Aula

* `File` representa arquivos e diretórios.
* `FileInputStream` / `FileOutputStream` trabalham com bytes.
* `DataInputStream` / `DataOutputStream` manipulam tipos primitivos.
* `ObjectInputStream` / `ObjectOutputStream` permitem serializar e desserializar objetos.
* `PrintWriter` e `BufferedReader` são usados para persistência em texto (CSV).
* O formato binário é mais eficiente; o CSV é mais interoperável e fácil de visualizar.