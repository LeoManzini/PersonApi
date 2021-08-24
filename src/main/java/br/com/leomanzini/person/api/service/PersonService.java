package br.com.leomanzini.person.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leomanzini.person.api.dto.mapper.PersonMapper;
import br.com.leomanzini.person.api.dto.request.PersonDto;
import br.com.leomanzini.person.api.dto.response.MessageResponseDto;
import br.com.leomanzini.person.api.entity.Person;
import br.com.leomanzini.person.api.exceptions.PersonNotFoundException;
import br.com.leomanzini.person.api.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	private final PersonMapper personMapper = PersonMapper.INSTANCE;

	public MessageResponseDto createPerson(PersonDto person) {
		Person personToSave = personMapper.toModel(person);

		Person savedPerson = personRepository.save(personToSave);

		return createMessageResponse(savedPerson.getId(), "Created person with ID: ");
	}

	public List<PersonDto> listAll() {
		List<Person> allPeople = personRepository.findAll();

		return allPeople.stream().map(personMapper::toDto).collect(Collectors.toList());
	}

	public PersonDto findById(Long id) throws Exception {
		Person person = verifyIfExists(id);

		return personMapper.toDto(person);
	}
	
	public MessageResponseDto updateById(Long id, PersonDto personDto) throws Exception {
		verifyIfExists(id);
		
		Person personToUpdate = personMapper.toModel(personDto);

		Person personUpdated = personRepository.save(personToUpdate);

		return createMessageResponse(personUpdated.getId(), "Updated person with ID: ");
	}
	
	public void deleteById(Long id) throws Exception {
		verifyIfExists(id);
		
		personRepository.deleteById(id);
	}
	
	private Person verifyIfExists(Long id) throws Exception {
		return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
	}
	
	private MessageResponseDto createMessageResponse(Long id, String message) {
		return MessageResponseDto.builder().message(message + id).build();
	}
}
