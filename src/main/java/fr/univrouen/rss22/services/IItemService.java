package fr.univrouen.rss22.services;

import fr.univrouen.rss22.iServices.ItemService;
import fr.univrouen.rss22.models.Item;
import fr.univrouen.rss22.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class IItemService implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> findItems()
    {
       var items=itemRepository.findAll();
      return items;
    }

    @Override
    public Optional<Item> findItemById(UUID id) {
        return itemRepository.findById(id);
    }
}
