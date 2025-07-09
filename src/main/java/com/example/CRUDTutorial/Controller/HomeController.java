package com.example.CRUDTutorial.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/logout")
    public String logout() {
        return "/login";
    }

    @GetMapping("/products")
    public String products() {
        return "/products/";
    }

    @GetMapping("/login")
    public String login() {
        return "/login/";
    }

    @GetMapping("/customers")
    public String customers() {
        return "/customers/";
    }
}
