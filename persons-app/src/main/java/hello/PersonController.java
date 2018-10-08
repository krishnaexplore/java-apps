package hello;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PersonController {

	private PersonRepository repository;
	public PersonController(PersonRepository repository) {
		this.repository = repository;
	}
	 @GetMapping(path = "/persons")
	    public List<Person> all() {
	        //throw new RuntimeException("some exception");
	        return this.repository.findAll();
	    }
}
