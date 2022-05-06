package fr.univrouen.rss22.models;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import fr.univrouen.rss22.enums.TypeImage;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;

@JacksonXmlRootElement(localName = "Image")
@Entity
@Table(name = "image")

public class Image implements Serializable {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private long Id;

    @Getter @Setter
    @JacksonXmlProperty(isAttribute = true)
    private TypeImage type;

    @Getter @Setter
    @JacksonXmlProperty(isAttribute = true)
    private String href;

    @Getter @Setter
    @JacksonXmlProperty(isAttribute = true)
    private String alt;

    @Getter @Setter
    @JacksonXmlProperty(isAttribute = true)
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
