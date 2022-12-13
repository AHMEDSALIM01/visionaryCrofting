package com.visionaryCrofting.demo.controllers;

import com.visionaryCrofting.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommandeItemController {
    @Autowired
    ProductService productService;

    @GetMapping("/panier")
    public String Panier(){
        return "commandItems";
    }
}
