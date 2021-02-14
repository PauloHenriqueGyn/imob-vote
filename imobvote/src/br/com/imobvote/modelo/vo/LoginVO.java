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
@Table(name="login")
@Getter
@Setter
public class LoginVO implements Serializable {

	private static final long serialVersionUID = 8311618373428553629L;
	
	@Id
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	private UUID id;
	
	@Column(name = "email")
	private String email;

	@Column(name = "senha")
	private String senha;

}
