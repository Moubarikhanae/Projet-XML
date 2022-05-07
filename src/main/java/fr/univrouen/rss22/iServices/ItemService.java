package fr.univrouen.rss22.iServices;


import fr.univrouen.rss22.models.Item;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface ItemService {
    List<Item> findItems();
    Optional<Item> findItemById(UUID id);
    Item insertItem(Item item);
    Optional<Item> findItemByTitle(String title);
    Optional<Item> findItemByDateAndTitle(Date date,String title);
    void deleteItem(UUID guid);
}
