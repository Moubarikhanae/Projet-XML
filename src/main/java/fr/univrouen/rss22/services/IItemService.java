package fr.univrouen.rss22.services;

import fr.univrouen.rss22.iServices.ItemService;
import fr.univrouen.rss22.models.Item;
import fr.univrouen.rss22.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
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

    @Override
    public void insertItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public Optional<Item> findItemByTitle(String title) {
        return itemRepository.findByTitle(title);
    }

    @Override
    public Optional<Item> findItemByDate(Date date) {
        return itemRepository.findByDate(date);
    }
}
