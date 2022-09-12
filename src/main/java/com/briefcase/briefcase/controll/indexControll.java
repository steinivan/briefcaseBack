
package com.briefcase.briefcase.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexControll {
    @GetMapping("/api")
    public String pageInit(){
        return "index";
    }
}
