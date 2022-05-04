package fr.univrouen.rss22.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@XmlRootElement(name="item")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="item")
public class Item {

    @Getter @Setter
    @Id
    private UUID guid;

    @XmlElement(name="title")
    @Column(length = 64)
    private String title;

    @XmlElement(name="category")
    @OneToMany( targetEntity=Category.class, mappedBy="item" )
    private List<Category> categories=new ArrayList<Category>();

    @Getter @Setter
    @XmlElements({
            @XmlElement(name="published", type= Date.class),
            @XmlElement(name="updated",type=Date.class)
    })
    private Date publishedOrUpdated;

    @Getter @Setter
    @XmlElement(name="image")
    @ManyToOne
    @JoinColumn(name="id_image")
    private Image image;

    @Getter @Setter
    @XmlElement(name="content")
    @ManyToOne
    @JoinColumn(name="id_content")
    private Content content;


    @Getter @Setter
    @XmlElements({
            @XmlElement(name="author", type= Person.class),
            @XmlElement(name="contributor",type=Person.class)
    })

    @OneToMany( targetEntity=Person.class, mappedBy="item" )
    private List<Person> authorOrContributor=new ArrayList<>();

    public Item() {
    }

    @Override
    public String toString() {
        return "Item{" +
                "guid=" + guid +
                ", title='" + title + '\'' +
                ", categories=" + categories +
                ", publishedOrUpdated=" + publishedOrUpdated +
                ", image=" + image +
                ", content=" + content +
                ", authorOrContributor=" + authorOrContributor +
                '}';
    }
}
