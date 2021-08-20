package br.com.leomanzini.person.api.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leomanzini.person.api.dto.MessageResponseDto;
import br.com.leomanzini.person.api.entity.Person;
import br.com.leomanzini.person.api.repository.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	private PersonRepository personRepository;

	@Autowired
	public PersonController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	@PostMapping
	public MessageResponseDto createPerson(@RequestBody Person person) {
		Person savedPerson = personRepository.save(person);
		
		return MessageResponseDto
				.builder()
				.message("Created person with ID: " + savedPerson.getId())
				.build();
	}
	
	@GetMapping
	public List<Person> readAllPerson() {
		return personRepository.findAll();
	}
	
	@GetMapping("/{person-id}")
	public Optional<Person> readPersonById(@PathParam("person-id") Long personId) {
		return personRepository.findById(personId);
	}
}
