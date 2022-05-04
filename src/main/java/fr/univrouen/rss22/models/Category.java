package fr.univrouen.rss22.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="category")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private long Id;

    @Getter @Setter
    @XmlAttribute(name = "term")
    private String term;

    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name="id_item")
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
