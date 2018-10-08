package hello;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.io.IOUtils;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;



public class Application {
	
	private static final int POPULATION_SIZE = 1000;
	
	public static void main(String args[]) {

		Application app = new Application();
		List<String> lastNames = app.loadNames("dist.all.last");
		List<String> firstNamesFemale = app.loadNames("dist.female.first");
		List<String> firstNamesMale = app.loadNames("dist.male.first");
		firstNamesFemale.addAll(firstNamesMale);

		Random randomizer = new Random();

		List<Person> persons = IntStream.range(1, POPULATION_SIZE)
				.mapToObj(n -> new Person(UUID.randomUUID().toString(),
						firstNamesFemale.get(randomizer.nextInt(firstNamesFemale.size())),
						lastNames.get(randomizer.nextInt(lastNames.size())))

				).collect(Collectors.toList());

		persons.forEach(System.out::println);

		System.out.println(System.getenv("mongo"));
		MongoClient mongoClient = new MongoClient("172.17.0.2", 27017);
		MongoDatabase database = mongoClient.getDatabase("myMongoDb");
		MongoCollection<Document> collections = database.getCollection("persons");
		System.out.println(collections.countDocuments());

	}
	
	private List<String> loadNames(String resource) {

		try {

			InputStream in = getClass().getClassLoader().getResourceAsStream(resource);
			return IOUtils.readLines(in, StandardCharsets.UTF_8).stream().map(l -> l.split("\\s+")[0])
					.collect(Collectors.toList());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
