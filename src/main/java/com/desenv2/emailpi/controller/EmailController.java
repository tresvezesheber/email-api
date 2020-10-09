package com.desenv2.emailpi.controller;

import com.desenv2.emailpi.model.Email;
import com.desenv2.emailpi.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
//    public ResponseEntity<Void> enviar(@RequestParam("email") Email email, @RequestPart(value = "files", required = false) MultipartFile[] anexo, HttpServletRequest request) throws IOException {
    public ResponseEntity<Void> enviar(@RequestBody Email email, @RequestPart(value = "files", required = false) MultipartFile[] anexo, HttpServletRequest request) {
        emailService.sendMail(email);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}