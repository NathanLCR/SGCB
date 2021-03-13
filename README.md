# Sistema de gestão de contas bancárias

Projeto para gestão de contas bancárias, proposto no desafio de seleção da UniFacisa. 

### 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- [Spring](https://spring.io/)
- [Liquibase](https://www.postgresql.org/)
- [PostgreSQL](https://www.postgresql.org/)
- [MapStruct](https://mapstruct.org/)

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [Java](https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html),
[Maven](https://maven.apache.org/), [Docker](https://www.docker.com/), [Docker Compose](https://docs.docker.com/compose/install/).

### 🎲 Rodando o Back End (servidor)

```bash
# Clone este repositório
$ git clone <https://github.com/NathanLCR/SGCB.git>

# Acesse a pasta do projeto no terminal/cmd
$ cd SGCB

# Acesse a pasta do docker no terminal/cmd
$ cd docker

# Execute o docker
$ docker-compose -f docker-compose-dev.yml up -d

# Volte a pasta do projeto
$ cd ../

# Execute o clean install do maven
$ mvn clean install

# Execute a aplicação em modo de desenvolvimento
$ ./mvnw

# O servidor inciará na porta:8080 - acesse <http://localhost:8080>