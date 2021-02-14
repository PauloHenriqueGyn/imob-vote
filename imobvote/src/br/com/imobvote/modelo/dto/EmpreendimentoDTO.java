package br.com.imobvote.modelo.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpreendimentoDTO {

	private UUID id;
	private String descricao;
	private byte[] foto;
}
