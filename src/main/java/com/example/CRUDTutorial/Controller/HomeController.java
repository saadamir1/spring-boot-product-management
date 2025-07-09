package com.example.CRUDTutorial.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

   @GetMapping("/")
   public String home() {
       return "redirect:/products/";
   }

   @GetMapping("/logout")
   public String logout() {
       return "redirect:/products/";
   }

   @GetMapping("/products")
   public String products() {
       return "redirect:/products/";
   }

   @GetMapping("/login")
   public String login() {
       return "redirect:/products/";
   }

   @GetMapping("/customers")
   public String customers() {
       return "redirect:/customers/";
   }
}