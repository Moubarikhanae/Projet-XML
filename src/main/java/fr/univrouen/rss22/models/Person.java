package fr.univrouen.rss22.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="person")
@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private long Id;


    @Getter
    @Setter
    @XmlElement(name = "name")
    @Column(length = 64)
    private String name;

    @Getter
    @Setter
    @XmlElement(name = "email")
    @Email
    private String email;

    @Getter
    @Setter
    @XmlElement(name = "uri")
    private String uri;

    @ManyToOne
    @JoinColumn(name="id_item")
    @Getter
    @Setter
    private Item item;

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
