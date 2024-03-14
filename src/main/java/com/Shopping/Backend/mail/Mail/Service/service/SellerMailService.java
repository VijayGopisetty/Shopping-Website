package com.Shopping.Backend.mail.Mail.Service.service;

import com.Shopping.Backend.mail.Mail.Service.DTO.request.AddProductDTO;
import com.Shopping.Backend.mail.Mail.Service.utils.ShoppingLogger;
import com.Shopping.Backend.mail.Mail.Service.utils.MailUtils;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SellerMailService {
    @Autowired
    MailUtils mailUtils;
    public void sendAddProductMail(AddProductDTO addProductDTO) throws Exception{
        ShoppingLogger.logger.info("Request received in mail service");
        String emailId= addProductDTO.getMailId();
        String subject= addProductDTO.getSubjectLine();
        MimeMessage message=mailUtils.getMimeMessage();
        JavaMailSender mailSender= mailUtils.getJavaMailSender();
        MimeMessageHelper messageHelper=mailUtils.getMimeMessageHelper();
        ShoppingLogger.logger.info("Configuration complete");
        try{
            ShoppingLogger.logger.info("came to mail service try block");
            messageHelper.setTo(emailId);
            messageHelper.setSubject(subject);
            messageHelper.setText(addProductDTO.getMailMessage());
            ShoppingLogger.logger.info("Sent mail");
            mailSender.send(message);
            ShoppingLogger.logger.info("Sent mail after message");
        }
        catch(Exception exception){
            throw exception;
        }
    }
}
