package com.project.shop;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

//TODO: create a dynamic url controller for products

@Controller
public class RootController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Home");
        model.addAttribute("contentType", "home");
        return "index";
    }

    @GetMapping("/products/{name}")
    public String catalog(@PathVariable String name, Model model) {
        model.addAttribute("title", name); // TODO: dynamic product name
        model.addAttribute("contentType", "catalog");
        model.addAttribute("productName", name);
        return "index";
    }
}
