package br.com.leomanzini.person.api.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.leomanzini.person.api.dto.request.PersonDto;
import br.com.leomanzini.person.api.dto.response.MessageResponseDto;
import br.com.leomanzini.person.api.entity.Person;
import br.com.leomanzini.person.api.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	private PersonService personService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDto createPerson(@RequestBody @Valid PersonDto person) {
		return personService.createPerson(person);
	}
	
//	@GetMapping
//	public List<Person> readAllPerson() {
//		return personService.findAll();
//	}
//	
//	@GetMapping("/{person-id}")
//	public Optional<Person> readPersonById(@PathParam("person-id") Long personId) {
//		return personService.findById(personId);
//	}
}
