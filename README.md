# sistema-cursos
Agregar el archivo application.properties en src/main/resources con los siguientes datos<br /><br />
server.port=8080<br />
spring.thymeleaf.cache=false<br />
spring.datasource.url=jdbc:mysql://localhost:3306/#NOMBRE BASE DE DATOS#?serverTimezone=UTC<br />
spring.datasource.username=#USER DATABASE#<br />
spring.datasource.password=#PASSWORD DATABASE#<br />
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver<br />
spring.jpa.hibernate.ddl-auto=update<br />
spring.mail.host=#HOST EMAIL#<br />
spring.mail.port=#PORT EMAIL#<br />
spring.mail.username=#USER EMAIL#<br />
spring.mail.password=#PASSWORD EMAIL#<br />
spring.mail.properties.mail.smtp.auth=true<br />
spring.mail.properties.mail.smtp.starttls.enable=true<br />
