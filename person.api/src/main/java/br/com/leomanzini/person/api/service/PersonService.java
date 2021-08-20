package br.com.leomanzini.person.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leomanzini.person.api.dto.response.MessageResponseDto;
import br.com.leomanzini.person.api.entity.Person;
import br.com.leomanzini.person.api.repository.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public MessageResponseDto createPerson(Person person) {
		Person savedPerson = personRepository.save(person);
		
		return MessageResponseDto
				.builder()
				.message("Created person with ID: " + savedPerson.getId())
				.build();
	}
}
