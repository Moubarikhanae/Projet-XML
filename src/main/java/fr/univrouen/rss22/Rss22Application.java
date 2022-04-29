package fr.univrouen.rss22;

import fr.univrouen.rss22.models.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

@SpringBootApplication
public class Rss22Application {

    public static void main(String[] args) {
        SpringApplication.run(Rss22Application.class, args);

        Person person=new Person("Hanae","hanae@gmail.com","https://ici.com");

        jaxbObjectToXML(person);

    }

    private static void jaxbObjectToXML(Person person){
        try{
            JAXBContext jaxbContext=JAXBContext.newInstance(Person.class);
            Marshaller jaxbMarshaller= jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);

            jaxbMarshaller.marshal(person, new File("person.xml"));


        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
