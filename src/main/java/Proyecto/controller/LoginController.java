package Proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author aaron
 */
@Controller
public class LoginController {
    
    @GetMapping("/login")
    public String index(){
        return "/login";
    }
    
}
