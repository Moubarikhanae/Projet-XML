package fr.univrouen.rss22.DTOs;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlSchemaType;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@JacksonXmlRootElement(localName = "item")
public class ItemListDTO implements Serializable {
    @Getter
    @Setter
    @JacksonXmlProperty
    private UUID guid;

    @Getter @Setter
    @JacksonXmlProperty
    private String title;


    @Getter @Setter
    @JacksonXmlProperty
    @XmlSchemaType(name="date")
    private Date publishedOrUpdated;

    public ItemListDTO() {
    }

    public ItemListDTO(UUID guid, String title, Date publishedOrUpdated) {
        this.guid = guid;
        this.title = title;
        this.publishedOrUpdated = publishedOrUpdated;
    }

    @Override
    public String toString() {
        return "ItemListDTO{" +
                "guid=" + guid +
                ", title='" + title + '\'' +
                ", publishedOrUpdated=" + publishedOrUpdated +
                '}';
    }
}
