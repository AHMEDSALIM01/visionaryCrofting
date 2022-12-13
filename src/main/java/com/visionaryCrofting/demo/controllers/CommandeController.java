package com.visionaryCrofting.demo.controllers;

import com.visionaryCrofting.demo.entity.CommandeItem;
import com.visionaryCrofting.demo.service.CommandItemService;
import com.visionaryCrofting.demo.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommandeController {
    @Autowired
    CommandService commandService;
    @Autowired
    CommandItemService commandItemService;

    @PostMapping("/commander")
    public ResponseEntity<String> myControllerMethod(@RequestBody List<CommandeItem> commandeItems) {

        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
