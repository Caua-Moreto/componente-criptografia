# Componente de Criptografia (BRADECO) ✨

![Build](https://img.shields.io/badge/build-passing-brightgreen?style=for-the-badge)
![Maven Central](https://img.shields.io/maven-central/v/io.github.caua-moreto/componente-criptografia?style=for-the-badge)
![License](https://img.shields.io/badge/license-Apache%202.0-blue?style=for-the-badge)
![Java](https://img.shields.io/badge/java-17-orange?style=for-the-badge)

Um componente Java simples, construído com Maven, para demonstrar a aplicação dos 5 princípios **S.O.L.I.D.** no desenvolvimento de software orientado a componentes.

---

### Tabela de Conteúdos
1.  [Sobre o Projeto](#sobre-o-projeto)
2.  [Os 5 Princípios SOLID Aplicados](#os-5-princípios-solid-aplicados)
3.  [Como Começar](#como-começar)
    * [Pré-requisitos](#pré-requisitos)
    * [Instalação](#instalação)
4.  [Exemplo de Uso](#exemplo-de-uso)
5.  [Comandos Úteis](#comandos-úteis)
6.  [Licença](#licença)
7.  [Contato](#contato)

---

## Sobre o Projeto

Este projeto foi desenvolvido como requisito da disciplina de **Desenvolvimento de Componentes (BRADECO)** do curso de Tecnologia em Análise e Desenvolvimento de Sistemas do **Instituto Federal de São Paulo (IFSP)**.

O objetivo principal não é criar um algoritmo de criptografia seguro, mas sim construir um componente de software flexível, desacoplado e extensível, aplicando rigorosamente os cinco princípios do design orientado a objetos do S.O.L.I.D.

O componente oferece:
* Interfaces segregadas para criptografia e descriptografia.
* Duas implementações concretas: uma usando Base64 e outra usando uma simples inversão de string.
* Estrutura pronta para ser publicada no Maven Central.

## Os 5 Princípios SOLID Aplicados

Cada princípio foi aplicado para garantir um design de alta qualidade:

###  SRP - Princípio da Responsabilidade Única
Cada classe de implementação (`CriptografiaBase64Impl`, `CriptografiaInversaoImpl`) tem uma única responsabilidade e um único motivo para mudar: a lógica do seu respectivo algoritmo.

### OCP - Princípio do Aberto/Fechado
O sistema está **aberto para extensão**, pois novas formas de criptografia podem ser adicionadas criando novas classes que implementem `CriptografiaInterface`, e **fechado para modificação**, pois não é necessário alterar o código existente para suportar essas novas implementações.

### LSP - Princípio da Substituição de Liskov
Qualquer implementação da `CriptografiaInterface` pode ser substituída por outra sem quebrar o sistema. A classe `App` demonstra isso ao usar um método genérico que aceita qualquer uma das implementações e continua funcionando corretamente.

### ISP - Princípio da Segregação de Interface
Em vez de uma única interface "gorda", temos interfaces menores e específicas (`Criptografador`, `Descriptografador`). Clientes que precisam apenas de uma funcionalidade não são forçados a depender de métodos que não usam.

### DIP - Princípio da Inversão de Dependência
Os módulos de alto nível (como a classe `App`) dependem de abstrações (`CriptografiaInterface`), e não de implementações de baixo nível. Isso desacopla o código e facilita a troca de componentes.

## Como Começar

Siga estas instruções para ter o projeto rodando na sua máquina local.

### Pré-requisitos
* **JDK 17** ou superior
* **Apache Maven** 3.8+
* **Git**

### Instalação

#### 1. Usando como Dependência no seu Projeto Maven
Para usar este componente no seu próprio projeto, adicione a seguinte dependência ao seu `pom.xml`:
```
xml
<dependency>
    <groupId>io.github.caua-moreto</groupId>
    <artifactId>componente-criptografia</artifactId>
    <version>1.0.0</version>
</dependency>
```

#### 2. Construindo a Partir do Código-Fonte
Se preferir compilar o projeto você mesmo:
```
# Clone o repositório
git clone [https://github.com/caua-moreto/componente-criptografia.git](https://github.com/caua-moreto/componente-criptografia.git)

# Navegue até a pasta do projeto
cd componente-criptografia

# Instale no seu repositório local
mvn clean install
```

---

### Exemplo de Uso
Veja como é simples instanciar e usar o componente:
```
import io.github.caua_moreto.criptografia.interfac.CriptografiaInterface;
import io.github.caua_moreto.criptografia.impl.CriptografiaBase64Impl;
import io.github.caua_moreto.criptografia.impl.CriptografiaInversaoImpl;

public class Exemplo {

    public static void main(String[] args) {
        // Instanciando a implementação com Base64
        CriptografiaInterface criptoBase64 = new CriptografiaBase64Impl();
        String texto = "Hello, SOLID!";

        String textoCriptografado = criptoBase64.criptografar(texto);
        System.out.println("Criptografado com Base64: " + textoCriptografado); // Saída: SGVsbG8sIFNPTElEIQ==

        String textoOriginal = criptoBase64.descriptografar(textoCriptografado);
        System.out.println("Descriptografado: " + textoOriginal); // Saída: Hello, SOLID!
    }
}
```
---

## Comandos Úteis 🔧
#### Rodar todos os testes:
```
mvn test
```
#### Empacotar o projeto (gerar o .jar):
```
mvn package
```
#### Fazer o deploy para o Maven Central (requer configuração do settings.xml e GPG): 🚀
```
mvn clean deploy
```
---

## Licença
#### Distribuído sob a Licença Apache 2.0. Veja o arquivo LICENSE para mais informações.

## Contato
#### Cauã Moreto - cauamoreto@gmail.com
#### https://www.linkedin.com/in/caua-moreto/
#### Link do Projeto: https://github.com/caua-moreto/componente-criptografia
