package br.com.imobvote.modelo.vo;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.Setter;

@Entity
@DynamicInsert
@Table(name="votacao")
@Getter
@Setter
public class VotacaoVO {
	
	@Id
	@Column(name = "id")
	@GeneratedValue
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	private UUID id;

	@Column(name ="empreendimento")
	private UUID empreendimento;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "voto")
	private boolean voto;
	
}
