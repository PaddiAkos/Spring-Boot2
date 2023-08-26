package hu.akos.demo;

import hu.akos.demo.model.Person;
import hu.akos.demo.repository.PersonRepository;
import hu.akos.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner run(PersonRepository personRepository) {
		return args -> {
			Person person1 = new Person();
			person1.setFirstName("Zsolt");
			person1.setLastName("Fischer");
			person1.setBirthDate(LocalDate.of(1994, 9, 1));
			person1.setBirthPlace("Székesfehérvár");
			person1.setEmail("zsoltifischer@gmail.com");

			Person person2 = new Person();
			person2.setFirstName("Ákos");
			person2.setLastName("Paddi");
			person2.setBirthDate(LocalDate.of(1994, 1, 3));
			person2.setBirthPlace("Szekszárd");
			person2.setEmail("akospaddi@gmail.com");

			personRepository.save(person1);
			personRepository.save(person2);
		};
	}

}
