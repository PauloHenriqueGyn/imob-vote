package br.com.imobvote.modelo.vo;

import java.io.Serializable;
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
@DynamicUpdate
@Table(name="empreendimento")
@Getter
@Setter
public class EmpreendimentoVO implements Serializable {

	private static final long serialVersionUID = -7774404110823527617L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	private UUID id;

	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "foto")
	private byte[] foto;
	
}
