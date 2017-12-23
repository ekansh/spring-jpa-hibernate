package com.example;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;
import com.example.entity.Media;
import com.example.entity.Person;
import com.example.entity.Video;
import com.example.service.MediaService;
import com.example.service.PersonService;

/**
 * @author ekansh
 *
 */
public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

//      insertPerson(context);
      insertMedia(context);
      context.close();
   }

private static void insertMedia(AnnotationConfigApplicationContext context) {
	MediaService mediaService = context.getBean(MediaService.class);
		Media m = new Video();
		m.setName("Sample 1");
		mediaService.add(m);
		List<Media> listMedia = mediaService.listMedia();
		for (Media media : listMedia) {
			System.out.println("Media Name "+ media.getName());
		}
}

private static void insertPerson(AnnotationConfigApplicationContext context) {
	PersonService personService = context.getBean(PersonService.class);

      // Add Persons
      personService.add(new Person("Sunil", "Bora", "suni.bora@example.com"));
      personService.add(new Person("David", "Miller", "david.miller@example.com"));
      personService.add(new Person("Sameer", "Singh", "sameer.singh@example.com"));
      personService.add(new Person("Paul", "Smith", "paul.smith@example.com"));

      // Get Persons
      List<Person> persons = personService.listPersons();
      for (Person person : persons) {
         System.out.println("Id = "+person.getId());
         System.out.println("First Name = "+person.getFirstName());
         System.out.println("Last Name = "+person.getLastName());
         System.out.println("Email = "+person.getEmail());
         System.out.println();
      }
}
}
