### CRIANDO UM MICROSERVICE DE ENVIO DE EMAIL:
* Microservice de envio de e-mail de forma autônoma e independente, que tem apenas essa responsabilidade.
* Anotações do video da Michelli Brito sobre como criar um ms de envio de e-mail:
  * https://youtu.be/ZBleZzJf6ro


#### Obs:
* Como não utilizei Java e acabei fazendo com Kotlin, optei por não utilizar o lombok pq não achei necessário.
* Além disso, o BeansUtils utilizado no video pra converter DTO para Model também não funcionou, dessa forma optei por utilizar uma interface Mapper.

---
#### Dependências:
* Spring Web.
* Spring Data JPA.
* PostgreSQL Driver.
* Validation.
* Java Mail Sender.
* Spring Doc.
* Flyway (porém não foram criadas migrations, acabou que não foi usado).

#### Configurações:
* Optei por subir uma instância de banco postgres através de Docker. Essa configuração pode ser acessada no arquivo docker-compose.yml.
* Demais configurações estão no application.properties (Tem HCC, mas não tem problema, pq criei um e-mail especificamente pra estudos).

#### Como rodar:
* Rodar na raiz do projeto o comando "docker-compose up" pra subir a imagem do banco postgres.
* Rodar a classe principal.
* Se necessário, desativar o AntiVirus pois ele pode causar o erro ""Mail server connection failed; nested exception is javax.mail.MessagingException: Could not convert socket to TLS":
  * // https://stackoverflow.com/questions/16115453/javamail-could-not-convert-socket-to-tls-gmail/59863295#59863295
* Acessar o swagger pra enviar as requisições: http://localhost:8080/swagger-ui/index.html
