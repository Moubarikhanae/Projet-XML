package fr.univrouen.rss22.models;

import fr.univrouen.rss22.enums.TypeContent;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="content")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="content")
public class Content {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private long Id;

    @Getter @Setter
    @XmlAttribute(name="type")
    private TypeContent type;

    @Getter @Setter
    @XmlAttribute(name="url")
    private String url;



    public Content() {
    }

    public Content(TypeContent type, String url) {
        this.type = type;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Content{" +
                "type=" + type +
                ", url='" + url + '\'' +
                '}';
    }
}
