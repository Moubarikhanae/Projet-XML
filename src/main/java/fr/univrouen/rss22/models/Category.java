package fr.univrouen.rss22.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;


@JacksonXmlRootElement(localName = "category")
@Entity
@Table(name="category")
public class Category implements Serializable {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private long Id;

    @Getter @Setter
    @JacksonXmlProperty(isAttribute = true)
    private String term;

    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name="id_item")
    @JsonIgnore
    private Item item;


    public Category() {
    }

    public Category(String term)
    {
        this.term=term;
    }

    @Override
    public String toString() {
        return "Category{" +
                ", term='" + term + '\'' +
                ", item=" + item +
                '}';
    }
}
