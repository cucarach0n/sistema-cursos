# sistema-cursos
Agregar el archivo application.properties en src/main/resources con los siguientes datos
server.port=8080
spring.thymeleaf.cache=false
spring.datasource.url=jdbc:mysql://localhost:3306/#NOMBRE BASE DE DATOS#?serverTimezone=UTC
spring.datasource.username=#USER DATABASE#
spring.datasource.password=#PASSWORD DATABASE#
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.mail.host=#HOST EMAIL#
spring.mail.port=#PORT EMAIL#
spring.mail.username=#USER EMAIL#
spring.mail.password=#PASSWORD EMAIL#
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
