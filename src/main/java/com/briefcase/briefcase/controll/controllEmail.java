
package com.briefcase.briefcase.controll;

import com.briefcase.briefcase.model.EmailModel;
import com.briefcase.briefcase.service.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class controllEmail {
    @Autowired
    private EmailService service;
    
    @PostMapping("/send")
    public void send(@RequestBody EmailModel email){
        String emailTo = "ivanuniversidad2020@outlook.com";
        System.out.println(email.getEmail());
        String content = email.getMessage().concat("\n numero de contacto: " + email.getPhone() + " from: " + email.getEmail());
        service.sendEmail(emailTo, email.getName(), content);
    }
}
