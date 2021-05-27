package it.epicode.be.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErroreMessaggio {
	
	private String messaggio; 
	private String developer_reference = "Contattare lo svillupatore";
	private HttpStatus stato;

}
