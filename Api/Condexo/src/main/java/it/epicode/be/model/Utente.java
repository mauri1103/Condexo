package it.epicode.be.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "utente")
public class Utente {

	@Id
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	private String users;
	private String nome;
	private String cognome;
	private LocalDate data_di_nascita;
	private String email;

}
