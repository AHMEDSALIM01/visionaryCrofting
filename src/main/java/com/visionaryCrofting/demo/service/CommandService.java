package com.visionaryCrofting.demo.service;

import com.visionaryCrofting.demo.entity.Commande;

import java.util.List;

public interface CommandService {
    List<Commande> getAllCommande();
    Commande getCommandeById(Long id);
    Commande getCommandeByRef(String ref);
    Commande addCommande(Commande commande);

    Commande updateCommande(Commande commande);

    String deleteCommande(Long id);

}
