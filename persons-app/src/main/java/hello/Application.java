package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of persons
		repository.save(new Person("Alice", "Smith"));
		repository.save(new Person("Bob", "Smith"));

		// fetch all persons
		System.out.println("Person found with findAll():");
		System.out.println("-------------------------------");
		for (Person person : repository.findAll()) {
			System.out.println(person);
		}
		System.out.println();

		// fetch an individual person
		System.out.println("person found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Person found with findByLastNameIgnoringCase('Smith'):");
		System.out.println("--------------------------------");
		for (Person person : repository.findByLastNameIgnoringCase("Smith")) {
			System.out.println(person);
		}

	}

}
