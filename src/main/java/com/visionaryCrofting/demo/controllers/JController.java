package com.visionaryCrofting.demo.controllers;

import com.visionaryCrofting.demo.entity.Commande;
import com.visionaryCrofting.demo.service.CommandItemService;
import com.visionaryCrofting.demo.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JController {
        @Autowired
        CommandService commandService;
        @Autowired
        CommandItemService commandItemService;

        @PostMapping("/response")
        public String myControllerMethod(@RequestBody Commande commande) {

            return "";
        }
}
