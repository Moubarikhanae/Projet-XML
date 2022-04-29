package fr.univrouen.rss22.models;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="category")
@XmlAccessorType(XmlAccessType.FIELD)
public class Category {

    @Getter @Setter
    @XmlAttribute(name = "term")
    private String term;

    public Category(String term)
    {
        this.term=term;
    }
}
