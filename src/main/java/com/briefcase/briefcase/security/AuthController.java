
package com.briefcase.briefcase.security;

import com.briefcase.briefcase.security.dto.SignInRequest;
import com.briefcase.briefcase.security.dto.UserRequest;
import com.briefcase.briefcase.security.entity.User;
import com.briefcase.briefcase.security.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class AuthController {
    @Autowired
    private AccountService service;
    
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SignInRequest signInRequest) {
        UserRequest res = new UserRequest();
        try{
            User dataUser = service.signUser(signInRequest);
            if(dataUser.getPassword().equals(signInRequest.getPassword()) ){
                res.setId(dataUser.getId());
                res.setUsername(dataUser.getUsername());
                res.setEmail(dataUser.getEmail());
                return ResponseEntity.ok(res);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("password invalid");
            } 
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("email invalid");
        }
    }

}
