package fr.univrouen.rss22.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
@Table( name = "person" )
@JacksonXmlRootElement( localName = "person" )
public class Person implements Serializable{
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private long Id;

    @Getter
    @Setter
    @JacksonXmlProperty
    @Column( length = 64 )
    private String name;

    @Getter
    @Setter
    @JacksonXmlProperty
    @Email
    private String email;

    @Getter
    @Setter
    @JacksonXmlProperty
    private String uri;

    @ManyToOne
    @JoinColumn( name = "id_item" )
    @Getter
    @Setter
    @JsonIgnore
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
