package hello;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

interface PersonRepository extends MongoRepository<Person, String> {
    public Person findByFirstName(String firstName);

    public List<Person> findByLastNameIgnoringCase(String lastName);
}
