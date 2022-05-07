package fr.univrouen.rss22.services;

import fr.univrouen.rss22.iServices.PersonService;
import fr.univrouen.rss22.models.Person;
import fr.univrouen.rss22.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IPersonService implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public void updatePerson(Person person) {
        personRepository.save(person);
    }
}
