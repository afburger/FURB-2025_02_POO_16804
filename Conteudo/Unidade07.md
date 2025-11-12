# Aula 25 – Interfaces Gráficas com Java Swing

## Estrutura em Camadas

Antes de começar a trabalhar com interfaces gráficas, é importante entender o conceito de **separação de camadas** em um sistema:

* **Camada de Apresentação (Interface Gráfica):** responsável pela interação com o usuário (JFrame, JPanel, etc.).
* **Camada de Regras de Negócio:** onde ficam as classes que realizam o processamento e as regras do sistema.
* **Camada de Dados:** onde ocorre o armazenamento ou acesso a informações (banco de dados, arquivos, etc.).

Essa separação facilita a manutenção, reutilização e teste do código, permitindo que a interface mude sem afetar a lógica principal.

---

## JOptionPane

O `JOptionPane` é uma classe simples para **entrada e saída de dados** através de caixas de diálogo. É muito usada em aplicações pequenas ou em exemplos introdutórios de GUI.

```java
String nome = JOptionPane.showInputDialog("Digite seu nome:");
JOptionPane.showMessageDialog(null, "Olá, " + nome + "!");
```

Principais métodos:

* `showMessageDialog()` → exibe mensagens.
* `showInputDialog()` → solicita um valor do usuário.
* `showConfirmDialog()` → mostra opções de confirmação (Sim, Não, Cancelar).

---

## Criando uma Interface Gráfica

Para criar interfaces mais complexas, utilizamos **componentes visuais** do Swing.

### Exemplo básico com JFrame e JPanel

```java
import javax.swing.*;

public class ExemploJanela {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Exemplo de JFrame");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(400, 300);

        JPanel painel = new JPanel();
        JLabel label = new JLabel("Digite seu nome:");
        JTextField campo = new JTextField(20);

        painel.add(label);
        painel.add(campo);

        janela.add(painel);
        janela.setVisible(true);
    }
}
```

---

## Componentes comuns do Swing

| Componente   | Função                                            |
| ------------ | ------------------------------------------------- |
| `JFrame`     | Janela principal do aplicativo                    |
| `JPanel`     | Painel de organização de componentes              |
| `JLabel`     | Exibição de texto não editável                    |
| `JTextField` | Campo de texto de entrada                         |
| `JComboBox`  | Lista suspensa de opções                          |
| `JTable`     | Tabela para exibição de dados em linhas e colunas |
| `JButton`    | Botão que executa uma ação ao ser clicado         |

---

## Layouts

Os **layouts** controlam o posicionamento dos componentes dentro dos painéis.

### BorderLayout

Divide o espaço em 5 regiões: `NORTH`, `SOUTH`, `EAST`, `WEST` e `CENTER`.

```java
JPanel painel = new JPanel(new BorderLayout());
painel.add(new JButton("Norte"), BorderLayout.NORTH);
painel.add(new JButton("Centro"), BorderLayout.CENTER);
```

### MigLayout

Mais flexível e moderno, permite organizar componentes em linhas e colunas, semelhante a uma planilha.

```java
JPanel painel = new JPanel(new MigLayout());
painel.add(new JLabel("Nome:"));
painel.add(new JTextField(20), "wrap");
painel.add(new JButton("Salvar"), "span, center");
```

> 💡 *Sugestão:* explore mais sobre layouts na documentação oficial do Swing e na biblioteca MigLayout para entender como criar interfaces mais dinâmicas e responsivas.

---

## Eventos e Interação com Botões

Para que os componentes reajam a ações do usuário (como cliques em botões), utilizamos **eventos** e **listeners**.

### Exemplo básico de evento com JButton

```java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExemploEventos {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo de Evento");
        JButton botao = new JButton("Clique aqui");

        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Botão clicado!");
            }
        });

        frame.add(botao);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
```

Nesse exemplo, o método `addActionListener()` registra um **ouvinte de evento** que executa o código dentro de `actionPerformed()` quando o botão é clicado.

Também é possível usar expressões **lambda** (em Java 8+):

```java
botao.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Botão clicado!"));
```

---

## Conclusão

A criação de interfaces gráficas com Swing é uma excelente forma de visualizar conceitos de POO aplicados, como **instanciação de objetos**, **composição**, e **interação entre classes**.