# Microserviço de Envio de Email

Este é um projeto de microserviço desenvolvido em Java que é responsável por enviar e-mails utilizando a biblioteca Java Mail Sender. A aplicação suporta o envio síncrono de e-mails através de verbos HTTP e também o envio assíncrono através do broker RabbitMQ. O projeto utiliza o sistema de gerenciamento de dependências Maven e conta com as seguintes dependências: data jpa, starter mail, validation, starter web, amqp, mysql connector e lombok.

## Configuração do Ambiente

Antes de executar o microserviço, é necessário configurar o ambiente corretamente. Siga os passos abaixo:

### 1. Banco de Dados

Certifique-se de ter o Docker e o Docker Compose instalados em seu sistema. Em seguida, crie um arquivo chamado docker-compose.yml com o seguinte conteúdo:

```yaml
version: '3.8'

services:
  mysql:
    image: mysql:8.0.31-oracle
    container_name: mysql-container
    ports:
      - "3306:3306"
    volumes:
      - mysql_data:/var/lib/mysql
    environment:
      MYSQL_ROOT_PASSWORD: sua_senha_root
      MYSQL_DATABASE: seu_banco_de_dados
      MYSQL_USER: seu_usuario
      MYSQL_PASSWORD: sua_senha

  phpmyadmin:
    image: phpmyadmin/phpmyadmin:latest
    container_name: phpmyadmin-container
    ports:
      - "8080:80"
    environment:
      PMA_HOST: mysql
      MYSQL_ROOT_PASSWORD: sua_senha_root

volumes:
  mysql_data:
```
Certifique-se de substituir as informações pelas configurações adequadas, como senha, nome do banco de dados, usuário, etc.

Em seguida, no terminal, navegue até o diretório onde o arquivo docker-compose.yml está localizado e execute o seguinte comando para iniciar o banco de dados e o phpMyAdmin:

```bash

docker-compose up -d
```
### 2. Configurações do Microserviço

Para configurar o microserviço, você pode modificar as propriedades no arquivo application.properties:

```properties

# Configurações do Banco de Dados
spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco_de_dados
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

# Configurações do Mail Sender
spring.mail.host=seu_host_smtp
spring.mail.port=seu_porta_smtp
spring.mail.username=seu_email
spring.mail.password=sua_senha_email

# Configurações do RabbitMQ
spring.rabbitmq.host=seu_host_rabbitmq
spring.rabbitmq.port=sua_porta_rabbitmq
spring.rabbitmq.username=seu_usuario_rabbitmq
spring.rabbitmq.password=sua_senha_rabbitmq
```
Se preferir, pode usar o arquivo do tipo yaml, basta apenas fazer a conversão.

Substitua as informações pelas configurações apropriadas, como as credenciais do seu servidor de e-mail, RabbitMQ, etc.

## Executando o Microserviço

Para executar o microserviço, você pode usar o comando Maven a seguir:

```bash
mvn spring-boot:run
```
O microserviço estará disponível em http://localhost:8080.

## Endpoints

O microserviço expõe os seguintes endpoints para enviar e-mails:

### Envio Síncrono de E-mail
Endpoint(POST): /sending-email

## Considerações Finais
Espero que este README possa ajudar a entender melhor o projeto! Qualquer dúvida ou sugestão, não hesite em entrar em contato.
