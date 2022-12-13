package com.visionaryCrofting.demo.ressources;

import com.visionaryCrofting.demo.entity.CommandeItem;
import com.visionaryCrofting.demo.service.CommandItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("${api.endpoint}/commandItem")
public class  CommandItemController {
    @Autowired
    private CommandItemService commandItemService;

    @GetMapping("/id/{id}")
    public Optional<CommandeItem> getByID(Long id) {return commandItemService.getById(id);}

    @GetMapping("/")
    public List<CommandeItem> getAll() {
        return commandItemService.getAll();
    }

    @GetMapping("/count")
    public int count() {
        return commandItemService.count();
    }

    @PostMapping("/")
    public CommandeItem save(@RequestBody CommandeItem commandeItem) {
        return  commandItemService.save(commandeItem);
    }

    @PutMapping("/")
    public CommandeItem update(@RequestBody CommandeItem commandeItem) {return (CommandeItem) commandItemService.update(commandeItem);}

    @DeleteMapping("/id/{aLong}")
    public void deleteById(@PathVariable Long id) {
        commandItemService.deleteById(id);
    }
}
