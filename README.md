Desafio C.E.S.A.R.
---
### Considerações:
A tecnologia escolhida para o desenvolvimento do desafio foi o Java na sua versão 8. Além disso, o código implementado conta com as seguintes características principais:

* Java Servlets;
* Material Design Lite;
* Ajax;
* JSON;
* Google Charts;
* Teste de Integração;
* Apache Maven para gerenciamento de dependências;
* Apache Tomcat.

### Requisitos Mínimos:
    - Java 8
    - Apache Maven
    - Apache Tomcat
    - Eclipse IDE

### Configuração do Ambiente:
Considerando que todos os requisitos mínimos citados já estejam instalados e configurados corretamente, para importar o projeto no eclipse, basta fazer o seguinte:

1) Clicar no menu File e selecionar a opção Import... logo em seguida, a janela Import será aberta
2) Na janela Import, abrir a pasta Maven, selecionar a opção Existing Maven Projects e clicar no botão Next
3) Clicar no botão Browser e selecionar a pasta do projeto enviado e clicar no botão OK
4) Em seguida, clicar no botão Finish e esperar que o maven baixe todas as dependências do projeto

Para fazer o deploy da aplicação no tomcat, é preciso primeiro, configurar os dados de acesso para o tomcat no arquivo pom.xml do projeto. Para isso modifique as tags url, path, username e password como mostrado no trecho abaixo:


```xml
...
<plugin>
	<groupId>org.codehaus.mojo</groupId>
	<artifactId>tomcat-maven-plugin</artifactId>
	<configuration>
		<url>http://localhost:8080/manager/text</url>
		<server>TomcatServer</server>
		<path>/desafiocesar</path>
		<username>admin</username>
		<password>password</password>
	</configuration>
</plugin>
...
```

Uma vez configurado, basta executar o seguinte comando no terminal:

    $ mvn tomcat:deploy

Para acessar a aplicação utilize o endereço: http://localhost:8080/desafiocesar

Caso o tomcat onde foi feito o deploy esteja em alguma outra máquina ou servidor, é preciso substituir localhost pelo IP da máquina ou servidor correspodente.