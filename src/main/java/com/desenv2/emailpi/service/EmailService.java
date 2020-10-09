package com.desenv2.emailpi.service;

import com.desenv2.emailpi.log.LogService;
import com.desenv2.emailpi.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Environment environment;

//    @Autowired
//    private EmailRepository emailRepository;


    public boolean sendMail(Email email) {
        try {
            MimeMessage mail = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mail);
            helper.setTo(email.getRecipient());
            helper.setSubject(email.getSubject());
            helper.setText(email.getHtmlContent(), true);
//            helper.setFrom(environment.getProperty("spring.mail.username"));

            mailSender.send(mail);
//            emailRepository.save(email);

            return true;
        } catch (Exception e) {
            LogService.logError(e, EmailService.class);
            return false;
        }
    }
}
