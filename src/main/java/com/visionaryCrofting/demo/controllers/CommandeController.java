package com.visionaryCrofting.demo.controllers;

import com.visionaryCrofting.demo.entity.Commande;
import com.visionaryCrofting.demo.entity.CommandeItem;
import com.visionaryCrofting.demo.service.ClientService;
import com.visionaryCrofting.demo.service.CommandItemService;
import com.visionaryCrofting.demo.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CommandeController {
    @Autowired
    CommandService commandService;
    @Autowired
    CommandItemService commandItemService;
    @Autowired
    ClientService clientService;

    @PostMapping("/commander")
    public ResponseEntity<Object> myControllerMethod(@RequestBody Commande commande) {
        List<CommandeItem> commandeItems1 = commande.getCommandeItems();
        System.out.println("-------------------commandItems from local storage");
        System.out.println(commandeItems1);
        System.out.println(commande.getPrixTotal());
        Commande commande1 = commande;
        commande1.setCommandeItems(new ArrayList<>());
        commande1.setDate(LocalDate.now());
        commande1.setClient(clientService.getOnById(Long.valueOf(1)).get());
        commande1=commandService.addCommande(commande1);
        System.out.println("-------------------commande");
        System.out.println(commande1);
        for (CommandeItem commandeItem:commandeItems1) {
            CommandeItem commandeItem2 = commandeItem;
            commandeItem2.setCommande(commande1);
            System.out.println("-------------------commandeItem Object----------------");
            System.out.println(commandeItem2);
            commandItemService.save(commandeItem2);
        }
        //List<CommandeItem> commandeItems2 = commandItemService.getAll();
        commande1.setCommandeItems(commandeItems1);
        System.out.println("-------------------commande aprés----------------");
        commandService.updateCommande(commande1);
        return ResponseEntity.ok(commande1);
    }
}
