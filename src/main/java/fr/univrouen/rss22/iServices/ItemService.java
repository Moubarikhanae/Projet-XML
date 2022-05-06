package fr.univrouen.rss22.iServices;


import fr.univrouen.rss22.models.Item;


import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ItemService {
    List<Item> findItems();
    Optional<Item> findItemById(UUID id);
}