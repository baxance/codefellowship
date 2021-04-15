package com.baxance.codefellowship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String home(Principal p, Model m){
        System.out.println("p" + p);
        if (p != null){
            System.out.println("p.getName() = " + p.getName());
        }
        return "index.html";
    }

    @GetMapping("/users")
    public String showDinos(Principal p, Model m){
        System.out.println("p.getName() = " + p.getName());

        m.addAttribute("user", p.getName());
        return "users.html";
    }

    @GetMapping("/*")
    public String catchAll(){
        return "users.html";
    }

}
