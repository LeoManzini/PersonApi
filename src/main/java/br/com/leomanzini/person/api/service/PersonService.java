package br.com.leomanzini.person.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leomanzini.person.api.dto.mapper.PersonMapper;
import br.com.leomanzini.person.api.dto.request.PersonDto;
import br.com.leomanzini.person.api.dto.response.MessageResponseDto;
import br.com.leomanzini.person.api.entity.Person;
import br.com.leomanzini.person.api.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	private final PersonMapper personMapper = PersonMapper.INSTANCE;

	public MessageResponseDto createPerson(PersonDto person) {
		Person personToSave = personMapper.toModel(person);

		Person savedPerson = personRepository.save(personToSave);

		return MessageResponseDto.builder().message("Created person with ID: " + savedPerson.getId()).build();
	}

	public List<PersonDto> listAll() {
		List<Person> allPeople = personRepository.findAll();

		return allPeople.stream().map(personMapper::toDto).collect(Collectors.toList());
	}
}
