/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rysoft.cursos.Servicios;

import com.rysoft.cursos.Interfaces.IPersonaService;
import com.rysoft.cursos.Modelos.Persona;
import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class UserService {

    @Autowired
    private IPersonaService userRepo;

    //@Autowired
    //private PasswordEncoder passwordEncoder;
    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void register(Persona persona, String siteURL) throws MessagingException, UnsupportedEncodingException {
        //String encodePassword = passwordEncoder.encode(persona.getUsuario().getContrasena_usuario());
        //persona.getUsuario().setContrasena_usuario(encodePassword);
        Persona perAux = userRepo.findByEmailEnable(persona.getUsuario().getCorreo_usuario(), 1);
        if (perAux == null) {
            String randomCode = RandomString.make(64);
            persona.setVerificationCode(randomCode);
            persona.setEnabled(false);
            userRepo.Guardar(persona);
            System.out.println("Registro Persona");
            sendVerificationEmail(persona, siteURL);
        }else{
            System.out.println("YA hay un Email registrado en esta cuenta");
        }
    }

    @Async
    public void sendVerificationEmail(Persona persona, String siteURL) throws MessagingException, UnsupportedEncodingException {
        String toAddress = persona.getUsuario().getCorreo_usuario();
        String fromAddress = "enviacms123@gmail.com";
        String senderName = "Cursos Rysoft";
        String subject = "Verifica tu Registro Porfavor";
        String contenido = "Estimad@ [[name]],<br>"
                + "Por favor, haga clic en el enlace de abajo para verificar su registro:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFICATE</a></h3>"
                + "Gracias,<br>"
                + "<h3 style='color:#bf0e09'>Cursos Rysoft.</h3>";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);
        contenido = contenido.replace("[[name]]", persona.getFullName());
        String verifyURL = siteURL + "/verify?code=" + persona.getVerificationCode();
        contenido = contenido.replace("[[URL]]", verifyURL);
        helper.setText(contenido, true);
        System.out.println("Enviar Email");
        mailSender.send(message);
    }

    public boolean verify(String verificationCode) {
        Persona persona = userRepo.findByVerificationCode(verificationCode);
        if (persona == null || persona.isEnabled()) {
            return false;
        } else {
            persona.setVerificationCode(null);
            persona.setEnabled(true);
            userRepo.Guardar(persona);
            return true;
        }
    }
}
