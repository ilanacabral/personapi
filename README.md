<h2>Digital Innovation: Bootcamp GFT Java & AWS Developer</h2>

Objetivo é desenvolver um pequeno sistema para o gerenciamento de pessoas de uma empresa através de uma API REST, criada com o Spring Boot.

Foram utilizados:

* Setup inicial de projeto com o Spring Boot Initialzr 
* Criação de modelo de dados para o mapeamento de entidades em bancos de dados
* Desenvolvimento de operações de gerenciamento de usuários (cadastro, leitura, atualização e remoção de pessoas de um sistema)
* Relação de cada uma das operações acima com o padrão arquitetural REST
* Desenvolvimento de testes unitários para validação das funcionalidades
* Implantação do sistema na nuvem através do Heroku

Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```

Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

```
http://localhost:8080/api/v1/person
```

Links para execução do projeto usando Heroku
```
* [Listar todos] https://personapi-icc.herokuapp.com/api/v1/person
* [Listar por id] https://personapi-icc.herokuapp.com/api/v1/person/1
* [Incluir] https://personapi-icc.herokuapp.com/api/v1/person
* [Alterar] https://personapi-icc.herokuapp.com/api/v1/person/1
* [Excluir] https://personapi-icc.herokuapp.com/api/v1/person/1
```

Exemplo de paylod para inclusão de pessoa:
```
{
    "firstName":"Mariatila",
    "lastName":"Marinho",
    "cpf":"076.185.841-50",    
    "birthDate":"10-10-1976" ,
    "phones":[{
        "type":"HOME",
        "number":"1234567891019"
    }]
}
```

Exemplo de paylod para alteração de pessoa:
```
{
    "id":"1",
    "firstName":"Mariatila",
    "lastName":"Marinho",
    "cpf":"076.185.841-50",    
    "birthDate":"10-10-1976" ,
    "phones":[{
        "id":"1",
        "type":"HOME",
        "number":"1234567891019"
    }]
}
```

São necessários os seguintes pré-requisitos para a execução do projeto desenvolvido durante a aula:

* Java 11 ou versões superiores
* Maven 3.6.3 ou versões superiores
* Visual Studio Code 1.60.2 ou versões superiores
* Controle de versão GitHub integrado na IDE
* Conta no GitHub para o armazenamento do seu projeto na nuvem.
* Conta no Heroku para o deploy do projeto na nuvem


Links úteis:

* [SDKMan! para gerenciamento e instalação do Java e Maven](https://sdkman.io/)
* [Referência do VSCode para download](https://code.visualstudio.com/)
* [Site oficial do Spring](https://spring.io/)
* [Site oficial do Spring Initialzr, para setup do projeto](https://start.spring.io/)
* [Site oficial do Heroku](https://www.heroku.com/)
* [Site oficial do GIT](https://git-scm.com/)
* [Site oficial do GitHub](http://github.com/)
* [Documentação oficial do Lombok](https://projectlombok.org/)
* [Documentação oficial do Map Struct](https://mapstruct.org/)
* [Referência para o padrão arquitetural REST](https://restfulapi.net/)