package com.visionaryCrofting.demo.ressources;

import com.visionaryCrofting.demo.entity.Product;
import com.visionaryCrofting.demo.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("${api.endpoint}/product")
public class ProductController {
    @Autowired
    private InterfaceService productService;

    @GetMapping("/id/{id}")
    public Optional<Product> getByID(Long id) {
        if(id<=0){
            System.out.println("id doit etre superieur strictement de 0");
        return null;
        }
        else
        return productService.getById(id);
    }

    @GetMapping("/")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/count")
    public int count() {
        return productService.count();
    }

    @PostMapping("/")
    public Product save(@RequestBody Product product) {
        return (Product) productService.save(product);
    }

    @DeleteMapping("/id/{aLong}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

}
