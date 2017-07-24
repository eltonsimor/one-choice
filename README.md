# One Choice

## Tecnologias Utilizadas:
1.  **Spring Boot** utilizei essa tecnologia para criação dos serviços **REST**.
2.  **JavaEE-API** para validação das entradas do request.
3.  **Java 8** línguagem de programação versão 8.
4.  **Gradle** para gerenciamento de dependências.
5.  **Design Pattern Strategy** padrão de desenvolvimento.
6. **Dozer** para converter qualquer tipo de objeto comparado pelos mesmos nomes de variaveis.


## Instruções para subir a aplicação Local:

#### Pré-Requisito:

* 1) Ter o Java 8 Instalado [Java](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).
* 2) Ter o Gradle [Gradle](https://services.gradle.org/distributions/gradle-2.14.1-all.zip).
* 3) Ter o Docker e Docker Compose [Docker for Mac](https://www.docker.com/docker-mac) / [Docker for Windows](https://www.docker.com/docker-windows) / [Docker for Linux](https://docs.docker.com/engine/installation/linux/docker-ee/ubuntu/)



#### Após realizar o pré-requisito vamos seguir o passo-a-passo


* 1) realizar o clone do projeto.
```javascript
    git clone git@github.com:eltonsimor/one-choice.git
```

* 2) realizar o seguinte comando na raiz do projeto no terminal.
```javascript
    docker-compose up
```

* 3) rodar o [script.sql](https://github.com/eltonsimor/one-choice/blob/master/script.sql) para criar as tabelas e o banco de dados.

* 4) Acessar a raíz do projeto e executar o comando:
```javascript
    gradle build
```

* 5) Após a finalização do build, executar o comando:
```javascript
'    java -jar build/libs/vianuvem-challenge-1.0.0.war   '
```

>Pronto! Aplicação já pode ser utilizada! ;)

**URLs ambiente Local**

_Página Principal:_
```
    http://localhost:8080/vianuvem/home
    
    ou 
    
    http://localhost:8080/vianuvem/
```

_Página para Cadastro de nova Lista:_
```
    http://localhost:8080/vianuvem/lists
```

**Request para o ambiente Local**

_Request para salvar uma nova Lista de Compras:_
```javascript
echo '{ "name":"Lista do Elton Moraes" }' | curl -X POST -d @- http://localhost:8080/vianuvem/saveList --header "Content-Type:application/json"
```

_Request para salvar uma nova Ordem:_
```javascript
echo '{ "name": "Maça", "quantity": 5, "price": 1.99, "nameImage": "laranja.jpg", "marked": "S","lists": {"pk": 1 } }' | curl -X POST -d @- http://localhost:8080/vianuvem/saveOrder --header "Content-Type:application/json"
```

_Request para obter as Listas:_
```javascript
curl -X GET http://localhost:8080/vianuvem/findAllLists --header "Content-Type:application/json"
```

_Request para obter Orders pelo ID da Lista:_
```javascript
curl -X GET http://localhost:8080/vianuvem/findOrdersByList?list_pk=2 --header "Content-Type:application/json"
```

_Request para obter todas as Orders:_
```javascript
curl -X GET http://localhost:8080/vianuvem/findAllOrders --header "Content-Type:application/json"
```
