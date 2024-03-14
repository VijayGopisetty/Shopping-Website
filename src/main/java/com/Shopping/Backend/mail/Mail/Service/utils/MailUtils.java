package com.Shopping.Backend.mail.Mail.Service.utils;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailUtils {
    //instance of java mail sender
    //Mime message-we need onj on mime message to create mail
    //mimeMessageHelper-with help of this we create mime message

    JavaMailSender javaMailSender;
    MimeMessageHelper mimeMessageHelper;
    MimeMessage mimeMessage;
    public MailUtils(){
        javaMailSender=new JavaMailSenderImpl();
        mimeMessage=javaMailSender.createMimeMessage();
        mimeMessageHelper=new MimeMessageHelper(mimeMessage);
    }
    public JavaMailSender getJavaMailSender() {
        return javaMailSender;
    }

    public MimeMessageHelper getMimeMessageHelper() {
        return mimeMessageHelper;
    }

    public MimeMessage getMimeMessage() {
        return mimeMessage;
    }
}
