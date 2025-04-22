package com.project.shop;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.server.ResponseStatusException;

//TODO: create a dynamic url controller for products

@Controller
public class RootController {
    @GetMapping("/")
    public String index(Model model) {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Home");
        model.addAttribute("contentType", "home");
        return "index";
    }

    @GetMapping("/products/{name}")
    public String catalog(@PathVariable String name, Model model) {
        if (name.equalsIgnoreCase("rings")     ||
            name.equalsIgnoreCase("earrings")  ||
            name.equalsIgnoreCase("necklaces") ||
            name.equalsIgnoreCase("bracelets"))
        {
            model.addAttribute("title", name);
            model.addAttribute("contentType", "catalog");
            model.addAttribute("productName", name.toUpperCase());
            return "index";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/account")
    public String account(Model model) {
        model.addAttribute("title", "Account");
        model.addAttribute("contentType", "account");
        return "index";
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("title", "Cart");
        model.addAttribute("contentType", "account");
        return "index";
    }

    @GetMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("title", "Checkout");
        model.addAttribute("contentType", "account");
        return "index";
    }
}
