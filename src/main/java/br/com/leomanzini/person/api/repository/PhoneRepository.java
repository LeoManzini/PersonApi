package br.com.leomanzini.person.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.leomanzini.person.api.entity.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
