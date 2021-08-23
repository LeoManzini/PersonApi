package br.com.leomanzini.person.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends Exception {

	private static final long serialVersionUID = -6374494466178545567L;
	
	public PersonNotFoundException(Long id) {
		super("Person not found at database with ID " + id);
	}
}
