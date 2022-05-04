package fr.univrouen.rss22.models;


import fr.univrouen.rss22.enums.TypeImage;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="image")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "image")

public class Image {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private long Id;

    @Getter @Setter
    @XmlAttribute(name="type")
    private TypeImage type;

    @Getter @Setter
    @XmlAttribute(name="href")
    private String href;

    @Getter @Setter
    @XmlAttribute(name="alt")
    private String alt;

    @Getter @Setter
    @XmlAttribute(name="length")
    private int length;

    public Image() {
    }

    public Image(TypeImage type, String href, String alt, int length) {
        this.type = type;
        this.href = href;
        this.alt = alt;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Image{" +
                "type=" + type +
                ", href='" + href + '\'' +
                ", alt='" + alt + '\'' +
                ", length=" + length +
                '}';
    }
}
