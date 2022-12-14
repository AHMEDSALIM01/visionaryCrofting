package com.visionaryCrofting.demo.controllers;

import com.visionaryCrofting.demo.entity.Product;
import com.visionaryCrofting.demo.service.implementation.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MarketController {
    @Autowired
    ProductServiceImp productService;
    @GetMapping("/")
    public String Market(@RequestParam(name="category",defaultValue = "") String categories , Model model){
        List<Product> products = productService.getAll();
        model.addAttribute("products",products);
        System.out.println("login");
        return "market";
    }
}
