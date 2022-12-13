package com.visionaryCrofting.demo.service;

import com.visionaryCrofting.demo.entity.CommandeItem;
import java.util.List;
import java.util.Optional;

public interface CommandItemService {
    Optional<CommandeItem> getById(Long id);
    List<CommandeItem> getAll() ;
    int count();
    CommandeItem save(CommandeItem t);
    CommandeItem update(CommandeItem t);
    void deleteById(Long id);
}
