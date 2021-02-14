package br.com.imobvote.modelo.dto;

import java.util.UUID;

import javax.persistence.Column;

public class VotacaoEmpreendimentoDTO {

	private UUID empreendimento;
	private String descricao; 
	private Integer totalVotos;
	
}
