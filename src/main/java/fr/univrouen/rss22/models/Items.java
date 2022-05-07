package fr.univrouen.rss22.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import fr.univrouen.rss22.DTOs.ItemListDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;


@JacksonXmlRootElement
public class Items implements Serializable {

    @JacksonXmlProperty( localName = "item" )
    @JacksonXmlElementWrapper( useWrapping = false )
    @Getter @Setter
    private ArrayList<ItemListDTO> items=new ArrayList<>();

}
