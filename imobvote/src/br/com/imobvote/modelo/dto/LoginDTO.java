package br.com.imobvote.modelo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {

	private String email;
	private String senha;
	private String token;
	
	
}
