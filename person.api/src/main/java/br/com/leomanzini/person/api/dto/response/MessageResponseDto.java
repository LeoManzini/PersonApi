package br.com.leomanzini.person.api.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDto {
	
	private String message;
}
