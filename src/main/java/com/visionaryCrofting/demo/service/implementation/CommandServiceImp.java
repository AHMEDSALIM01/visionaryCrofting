package com.visionaryCrofting.demo.service.implementation;
import com.visionaryCrofting.demo.entity.Commande;
import com.visionaryCrofting.demo.repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.visionaryCrofting.demo.service.CommandService;

import java.util.List;

@Service
public class CommandServiceImp implements CommandService{
    @Autowired
    CommandeRepository commandeRepository;
    // get all commande
    public List<Commande> getAllCommande(){
        return commandeRepository.findAll();
    }
    // get commande by id
    public Commande getCommandeById(Long id){
        Commande stest = commandeRepository.findById(id).orElse(null);
        if (stest == null){
            throw new IllegalStateException("Commande not found");
        }else{
            return stest;
        }
    }
    // get commande by ref
    public Commande getCommandeByRef(String ref){
        return commandeRepository.findByRef(ref);
    }
    // add commande
    public Commande addCommande(Commande commande){
        Commande commande1 = commandeRepository.findByRef(commande.getRef());
        // checkin if commande exist
        if ( commande1!= null){
            throw new IllegalStateException("Commande existe déja");
            // checking if command values are empty
        }else{
            return commandeRepository.save(commande);
        }
    }

    @Override
    public Commande updateCommande(Commande commande){
            return commandeRepository.save(commande);
    }
    // delete commande
    public String deleteCommande(Long id){
        commandeRepository.deleteById(id);
        return "Commande deleted";
    }
}
