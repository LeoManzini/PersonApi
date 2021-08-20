package br.com.leomanzini.person.api.entity;

import br.com.leomanzini.person.api.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {
	
	private Long id;
	private PhoneType type;
	private String number;
}
