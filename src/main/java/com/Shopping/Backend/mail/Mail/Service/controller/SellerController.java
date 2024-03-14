package com.Shopping.Backend.mail.Mail.Service.controller;

import com.Shopping.Backend.mail.Mail.Service.DTO.request.AddProductDTO;
import com.Shopping.Backend.mail.Mail.Service.DTO.response.GeneralMessageDTO;
import com.Shopping.Backend.mail.Mail.Service.utils.ShoppingLogger;
import com.Shopping.Backend.mail.Mail.Service.service.SellerMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail/seller")
public class SellerController {
    @Autowired
    SellerMailService sellerMailService;
    @PostMapping("/addproduct")
    public ResponseEntity addProduct(@RequestBody AddProductDTO addProductDTO){
        try {
            ShoppingLogger.logger.info("AddProductDTO req body"+addProductDTO.toString());
            ShoppingLogger.logger.info("Request received in mail controller");
            sellerMailService.sendAddProductMail(addProductDTO);
            ShoppingLogger.logger.info("Compiler came to controller from service");
            return new ResponseEntity(new GeneralMessageDTO(true), HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity(new GeneralMessageDTO(false),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
