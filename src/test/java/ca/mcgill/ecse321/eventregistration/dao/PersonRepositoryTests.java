package ca.mcgill.ecse321.eventregistration.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ca.mcgill.ecse321.eventregistration.model.Person;

@SpringBootTest
public class PersonRepositoryTests {
	@Autowired
	private PersonRepository personRepository;

	@AfterEach
	public void clearDatabase() {
		personRepository.deleteAll();
	}

	@Test
	public void testPersistAndLoadPerson() {
		// Create object
		String name = "Anakin Skywalker";
		Person anakin = new Person();
		anakin.setName(name);

		// Save object
		anakin = personRepository.save(anakin);
		String id = anakin.getName();

		// Read object from database
		anakin = personRepository.findPersonByName(id);

		// Assert that object has correct attributes
		assertNotNull(anakin);
		assertEquals(name, anakin.getName());
	}
}