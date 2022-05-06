package fr.univrouen.rss22.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import fr.univrouen.rss22.enums.TypeContent;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@JacksonXmlRootElement(localName = "content")
@Entity
@Table(name="content")
public class Content implements Serializable {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private long Id;

    @Getter @Setter
    @JacksonXmlProperty(isAttribute = true)
    private TypeContent type;

    @Getter @Setter
    @JacksonXmlProperty(isAttribute = true)
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
