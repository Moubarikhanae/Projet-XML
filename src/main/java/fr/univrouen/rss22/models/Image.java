package fr.univrouen.rss22.models;


import fr.univrouen.rss22.enums.TypeImage;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="image")
@XmlAccessorType(XmlAccessType.FIELD)
public class Image {

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
}
