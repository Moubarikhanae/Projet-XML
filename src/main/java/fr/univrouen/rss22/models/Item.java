package fr.univrouen.rss22.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@JacksonXmlRootElement(localName = "item")
@Entity
@Table(name="item")
public class Item implements Serializable {

    @Getter @Setter
    @Id
    @GeneratedValue( generator = "uuid2" )
    @GenericGenerator( name = "uuid2", strategy = "uuid2" )
    @Column( length=36, columnDefinition = "VARCHAR(36)" )
    @Type( type = "uuid-char" )
    @JacksonXmlProperty
    private UUID guid;

    @JacksonXmlProperty
    @Getter @Setter
    @Column( length = 64 )
    private String title;

    @Getter @Setter
    @JacksonXmlProperty
    @JsonFormat( pattern = "yyyy-MM-dd" )
    @Temporal(TemporalType.DATE)
    private Date publishedOrUpdated;

    @Getter @Setter
    @JacksonXmlProperty
    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "id_image" )
    private Image image;

    @Getter @Setter
    @JacksonXmlProperty
    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "id_content" )
    private Content content;

    @JacksonXmlProperty
    @Getter @Setter
    @OneToMany( targetEntity = Category.class, mappedBy = "item", cascade = CascadeType.ALL )
    private List<Category> categories=new ArrayList<Category>();

    @Getter @Setter
    @JacksonXmlProperty(localName="authorOrContributors")
    @OneToMany( targetEntity = Person.class, mappedBy = "item", cascade = CascadeType.ALL )
    private List<Person> authorOrContributor=new ArrayList<>();

    public Item() {
    }

    @Override
    public String toString() {
        return "Item{" +
                "guid=" + guid +
                ", title='" + title + '\'' +
                ", categories=" + categories +
                ", publishedOrUpdated=" + publishedOrUpdated +
                ", image=" + image +
                ", content=" + content +
                ", authorOrContributor=" + authorOrContributor +
                '}';
    }
}
