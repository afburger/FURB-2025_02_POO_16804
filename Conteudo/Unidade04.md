
# Aula 19 – Testes Unitários e JUnit

## 1. Introdução aos Testes Unitários

Os **testes unitários** têm como objetivo **verificar o funcionamento correto de pequenas partes do código**, geralmente **métodos**.  
Eles são fundamentais para garantir que cada componente do sistema funcione conforme o esperado, de forma isolada.

### Por que testar?
- Reduz erros e regressões durante o desenvolvimento.  
- Aumenta a confiança em mudanças no código.  
- Facilita a manutenção e refatoração.  
- Documenta o comportamento esperado de cada método.

Um bom teste deve ser **rápido, independente e repetível**.

---

## 2. Plano de Teste

Antes de implementar os testes, é importante planejar **o que será testado** e **como validar o resultado**.  
Um **plano de teste** ajuda a organizar os cenários e registrar o comportamento esperado.

### Estrutura de um Plano de Teste

| Campo | Descrição |
|-------|------------|
| **ID** | Identificador único do teste (ex: `TC001`) |
| **Descrição** | O que será testado e o motivo |
| **Entradas** | Dados ou parâmetros usados no teste |
| **Saída Esperada** | Resultado que o método deve retornar |
| **Resultado Obtido** | Resultado obtido após a execução |
| **Status** | Sucesso (`OK`) ou Falha (`FAIL`) |

### Exemplo:
| ID | Descrição | Entradas | Saída Esperada | Resultado Obtido | Status |
|----|------------|-----------|----------------|------------------|--------|
| TC001 | Testar soma de dois inteiros positivos | 2, 3 | 5 | 5 | OK |
| TC002 | Testar soma com número negativo | -1, 4 | 3 | 3 | OK |

---

## 3. O Framework JUnit

O **JUnit** é a principal biblioteca de testes unitários do Java.  
Permite criar, organizar e executar testes automatizados de forma simples.

Para utilizar, adicione a dependência no `junit-jupiter-api` ao seu projeto.

---

## 4. Criando um Teste Unitário

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    @Test
    public void deveSomarDoisNumeros() {
        Calculadora calc = new Calculadora();
        int resultado = calc.somar(2, 3);
        assertEquals(5, resultado, "A soma deve resultar em 5");
    }
}
```

- O método de teste é identificado pela **anotação `@Test`**.
- O método **não deve ter parâmetros** e **não deve retornar valor**.
- A validação é feita com **métodos de asserção**, como:

* `assertEquals(valorEsperado, valorObtido)`
* `assertTrue(condição)`
* `assertFalse(condição)`
* `assertThrows(Excecao.class, () -> método())`

---

## 5. Ciclo de Vida dos Testes e Anotações Importantes

O JUnit permite controlar a execução dos testes por meio de anotações.

### `@BeforeEach` e `@AfterEach`

Executam **antes e depois de cada teste**, respectivamente.
Usadas para preparar e limpar o ambiente de teste.

```java
import org.junit.jupiter.api.*;

public class BancoTest {

    Banco banco;

    @BeforeEach
    public void configurar() {
        banco = new Banco();
        banco.conectar();
    }

    @AfterEach
    public void limpar() {
        banco.desconectar();
    }

    @Test
    public void deveConterContaAposCadastro() {
        banco.adicionarConta("123");
        assertTrue(banco.existeConta("123"));
    }
}
```

---

### `@BeforeAll` e `@AfterAll`

Executam **uma única vez antes e depois de todos os testes da classe**.
Os métodos devem ser **estáticos**.

```java
@BeforeAll
public static void iniciarSuite() {
    System.out.println("Iniciando os testes...");
}

@AfterAll
public static void finalizarSuite() {
    System.out.println("Todos os testes finalizados.");
}
```

---

### `@TestMethodOrder`

Define a **ordem de execução dos testes**, quando for necessário (não recomendado para a maioria dos casos).

```java
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrdemTestes {

    @Test
    @Order(1)
    void primeiroTeste() {
        System.out.println("Executando primeiro teste");
    }

    @Test
    @Order(2)
    void segundoTeste() {
        System.out.println("Executando segundo teste");
    }
}
```

---

### `@Disabled`

Desativa temporariamente um teste (útil durante desenvolvimento).

```java
@Disabled("Em manutenção")
@Test
public void testeTemporariamenteDesativado() {
    fail("Este teste não deve ser executado");
}
```

---

### `@Timeout`

Define um **tempo máximo de execução** para o teste.
Se o tempo for ultrapassado, o teste falha automaticamente.
O valor informado é interpretado em segundos por padrão, mas é possível especificar outras unidades de tempo, como milissegundos, minutos ou horas, utilizando o segundo parâmetro da anotação.

```java
@Test
@Timeout(2) // limite de 2 segundos
public void testeComTempoMaximo() throws InterruptedException {
    Thread.sleep(1000); // executa em 1 segundo → passa
}

@Test
@Timeout(value = 500, unit = TimeUnit.MILLISECONDS) // limite de 500 milissegundos
public void testeComTempoEmMilissegundos() throws InterruptedException {
    Thread.sleep(600); // excede o tempo → falha
}
```
**Importante:**

O parâmetro 2 no exemplo representa 2 segundos.
Caso o método demore mais que esse tempo, o teste será interrompido e marcado como falhou (TimeoutException).
A unidade padrão é TimeUnit.SECONDS, mas pode ser alterada via o parâmetro unit.

---

### `@DisplayName`

Permite **personalizar o nome** do teste no relatório de execução, tornando a leitura mais amigável.

```java
@DisplayName("Teste de soma simples da calculadora")
@Test
public void testeSoma() {
    Calculadora calc = new Calculadora();
    assertEquals(10, calc.somar(4, 6));
}
```

---

## 6. Boas Práticas em Testes Unitários

* Dê **nomes descritivos** aos métodos de teste.
* Mantenha os testes **independentes** (um teste não deve depender do outro).
* Separe **cenário**, **ação** e **verificação** em cada teste:

  ```java
  // Arrange
  Calculadora calc = new Calculadora();
  // Act
  int resultado = calc.somar(2, 3);
  // Assert
  assertEquals(5, resultado);
  ```
* Evite lógica complexa dentro dos testes.
* Execute os testes com frequência.

---