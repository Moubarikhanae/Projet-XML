package fr.univrouen.rss22.models;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@XmlRootElement(name="item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {

    @Getter @Setter
    private UUID guid;

    @XmlElement(name="title")
    private String title;

    @XmlElement(name="category")
    private List<Category> categories=new ArrayList<Category>();

    @Getter @Setter
    @XmlElements({
            @XmlElement(name="published", type= Date.class),
            @XmlElement(name="updated",type=Date.class)
    })
    private Object publishedOrUpdated;

    @Getter @Setter
    @XmlElement(name="image")
    private Image image;

    @Getter @Setter
    @XmlElements({
            @XmlElement(name="author", type= Person.class),
            @XmlElement(name="contributor",type=Person.class)
    })

    private List<Object> authorOrContributor=new ArrayList<>();

}
