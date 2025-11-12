# Aula 21 – Bibliotecas de Estruturas de Dados, Ordenação e Igualdade de Objetos

## 1. Bibliotecas de Estruturas de Dados

A linguagem Java fornece um conjunto completo de classes e interfaces no pacote `java.util`, conhecidas como **Collections Framework**.  
Essas classes implementam estruturas de dados como listas, conjuntos e mapas, permitindo armazenar, organizar e manipular coleções de objetos de forma eficiente.

As principais interfaces do framework são:

| Interface | Estrutura Representada | Exemplo de Implementação |
|------------|------------------------|---------------------------|
| `List`     | Lista ordenada que permite elementos duplicados | `ArrayList`, `LinkedList` |
| `Set`      | Conjunto que **não permite duplicatas** | `HashSet`, `TreeSet` |
| `Map`      | Associação de **chave → valor** | `HashMap`, `TreeMap` |

---

## 2. Interface `List` e Suas Implementações

A interface `List` representa uma coleção **ordenada** de elementos, acessados por índice.  
As implementações mais comuns são:

### `ArrayList`
- Baseada em **vetor dinâmico**.  
- Acesso rápido a elementos (`get()` é O(1)).  
- Inserções e remoções no meio da lista podem ser custosas.

```java
List<String> nomes = new ArrayList<>();
nomes.add("Maria");
nomes.add("João");
nomes.add("Ana");
System.out.println(nomes.get(1)); // João
```

### `LinkedList`

* Baseada em **lista duplamente encadeada**.
* Inserções e remoções rápidas, mas acesso por índice é mais lento.

```java
List<String> nomes = new LinkedList<>();
nomes.add("Carlos");
nomes.addFirst("Beatriz"); // disponível apenas no LinkedList
System.out.println(nomes);
```

### Dica: Diagrama de Decisão

| Situação                         | Estrutura Recomendada  |
| -------------------------------- | ---------------------- |
| Acesso frequente por índice      | `ArrayList`            |
| Inserções e remoções frequentes  | `LinkedList`           |
| Necessidade de ordenação natural | `TreeSet` ou `TreeMap` |
| Busca rápida por chave           | `HashMap`              |

---

## 3. Ordenação de Coleções

Em Java, podemos ordenar coleções de duas formas:

### a) Ordenação Natural (`Comparable`)

Usada quando a própria classe define sua forma de comparação.

```java
public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public int compareTo(Pessoa outra) {
        return this.nome.compareTo(outra.nome);
    }
}

// Uso:
List<Pessoa> lista = new ArrayList<>();
lista.add(new Pessoa("Carlos", 25));
lista.add(new Pessoa("Ana", 30));
Collections.sort(lista);
```

### b) Ordenação Artificial (`Comparator`)

Usada quando queremos definir **diferentes critérios de comparação** sem alterar a classe original.

```java
Comparator<Pessoa> porIdade = (p1, p2) -> Integer.compare(p1.getIdade(), p2.getIdade());
Collections.sort(lista, porIdade);
```

---

## 4. Mapas de Dispersão (`Map`)

O `Map` armazena pares **chave → valor**, sendo que cada chave é única.

### `HashMap`

* Usa uma **tabela de dispersão (hash table)** para armazenar dados.
* Permite `null` como chave e valor.
* **Não garante ordem** dos elementos.

```java
Map<String, Integer> notas = new HashMap<>();
notas.put("Maria", 8);
notas.put("João", 9);
notas.put("Ana", 7);

System.out.println(notas.get("João")); // 9
```

### `TreeMap`

* Mantém os elementos **ordenados pela chave**.
* Não aceita `null` como chave.

```java
Map<String, Integer> notasOrdenadas = new TreeMap<>(notas);
System.out.println(notasOrdenadas);
```

---

## 5. Igualdade de Objetos (`equals` e `hashCode`)

Ao trabalhar com coleções, é fundamental entender como o Java compara objetos.
Por padrão, a comparação (`equals`) verifica apenas se as **referências** são iguais.
Para comparar **conteúdo**, devemos sobrescrever `equals` e `hashCode`.

### Exemplo:

```java
public class Produto {
    private int id;
    private String nome;

    public Produto(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Produto)) return false;
        Produto outro = (Produto) obj;
        return id == outro.id && nome.equals(outro.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}

// Teste:
Produto p1 = new Produto(1, "Caneta");
Produto p2 = new Produto(1, "Caneta");
System.out.println(p1.equals(p2)); // true
```

🔹 **Por que sobrescrever `hashCode`?**
Coleções como `HashSet` e `HashMap` usam o código de dispersão (`hashCode`) para agrupar objetos.
Se dois objetos são iguais (`equals` retorna `true`), **devem ter o mesmo `hashCode`**.

---

## 6. Resumo da Aula

* **`List`** → coleção ordenada, pode ter duplicatas.
* **`ArrayList`** e **`LinkedList`** têm desempenhos diferentes.
* **`Comparable`** → define ordenação natural.
* **`Comparator`** → define ordenação personalizada.
* **`Map`** → armazena pares chave/valor.
* **`equals` e `hashCode`** → fundamentais para garantir comportamento correto nas coleções.

---

