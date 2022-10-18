package com.rysoft.cursos.Servicios;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import javax.activation.DataHandler;
import javax.mail.MessagingException;
import javax.mail.Part;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    
    @Autowired
    private JavaMailSender mailSender;
    
    @Async
    public void sendEmail(String to, String subject, String text) throws MessagingException, MalformedURLException, UnsupportedEncodingException{
        /*//Esto es para enviar mensajes simples
        SimpleMailMessage message = new SimpleMailMessage();
        
        message.setFrom("enviacms123@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        //mailSender.send(message);
        */
        //Mensajes más Complejos
        
        String senderName = "Cursos Rysoft";
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage,true,"UTF-8");
        message.setFrom("enviacms123@gmail.com",senderName);
        /*
        Part attachment = new MimeBodyPart();
        URL url = new URL("https://www.zegelvirtual.com/sites/default/files/styles/productos/public/productos/BASICO.jpg.webp?itok=f6BeupXy");
        attachment.setDataHandler(new DataHandler(url));
        attachment.setDisposition(Part.ATTACHMENT);
        attachment.setFileName(url.getFile());*/
        message.setTo(to);
        message.setSubject(subject);
        message.setSentDate(new Date());
        message.setText(text,true);
        //message.addAttachment("ImagenCurso.webp", new ClassPathResource(attachment.getFileName()));//para enviar archivos adjuntos
        this.mailSender.send(mimeMessage);
    }
    
}
