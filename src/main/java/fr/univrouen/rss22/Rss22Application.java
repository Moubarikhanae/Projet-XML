package fr.univrouen.rss22;

import fr.univrouen.rss22.models.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class Rss22Application {

    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        SpringApplication.run(Rss22Application.class, args);

      /*  Person person=new Person("Hanae","hanae@gmail.com","https://ici.com");

        jaxbObjectToXML(person);
       */
       /* String personFile = "person.xml";
        // create JAXB context and unmarshaller
        var context = JAXBContext.newInstance(Person.class);
        var um = context.createUnmarshaller();

        var person = (Person) um.unmarshal(new InputStreamReader(
                new FileInputStream(personFile), StandardCharsets.UTF_8));
            System.out.println(person);
*/

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
