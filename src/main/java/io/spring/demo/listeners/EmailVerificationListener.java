package io.spring.demo.listeners;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import io.spring.demo.events.OnRegistrationEvent;
import io.spring.demo.models.User;
import io.spring.demo.services.TokenService;

public class EmailVerificationListener implements ApplicationListener<OnRegistrationEvent> {
    
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TokenService tokenService;


    @EventListener
    @Override
    public void onApplicationEvent(OnRegistrationEvent emailVerificationEvent) {
        System.out.println("System listened to Registration Event!!");
        this.confirmRegistration(emailVerificationEvent);
    }

    public void confirmRegistration(OnRegistrationEvent emailVerificationEvent) {
        User user = emailVerificationEvent.getUser();
        String token = UUID.randomUUID().toString();
        tokenService.createVerificationToken(user.getId(), token);

        String recipientAddress = user.getEmail();
        String subject = "Confirmación registro";
        String confirmationUrl = "localhost:3000/api/registrationConfirm?token=" + token;
        String text = "Haga click en el enlace de abajo para confirmar su email.";

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(text + "\r\n" + confirmationUrl);
        mailSender.send(email);
    }
}
