package fr.univrouen.rss22.mapping;


import fr.univrouen.rss22.DTOs.ItemListDTO;
import fr.univrouen.rss22.models.Item;

public class ItemMapper {

  /*public  static Item ItemDtoToEntity(ItemListDTO itemListDTO)
  {
      if(itemListDTO==null) return null;
  }*/
   public static ItemListDTO ItemEntityToDto(Item item)
   {
       if(item==null) return null;
       ItemListDTO itemListDTO=new ItemListDTO();
       itemListDTO.setGuid(item.getGuid());
       itemListDTO.setTitle(item.getTitle());
       itemListDTO.setPublishedOrUpdated(item.getPublishedOrUpdated());
       return itemListDTO;

   }
}
