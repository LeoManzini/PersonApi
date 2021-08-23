package br.com.leomanzini.person.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.leomanzini.person.api.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
