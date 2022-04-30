package fr.univrouen.rss22.models;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

    @Getter @Setter
    @XmlElement(name="name")
    private String name;

    @Getter @Setter
    @XmlElement(name="email")
    private String email;

    @Getter @Setter
    @XmlElement(name="uri")
    private String uri;

    public Person() {
    }

    public Person(String name, String email, String uri) {
        this.name = name;
        this.email = email;
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }
}
