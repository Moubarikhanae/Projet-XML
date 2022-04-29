package fr.univrouen.rss22.models;

import fr.univrouen.rss22.enums.TypeContent;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="content")
@XmlAccessorType(XmlAccessType.FIELD)
public class Content {

    @Getter @Setter
    @XmlAttribute(name="type")
    private TypeContent type;

    @Getter @Setter
    @XmlAttribute(name="url")
    private String url;
}
