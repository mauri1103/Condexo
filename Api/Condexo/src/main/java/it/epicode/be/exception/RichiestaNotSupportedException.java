package it.epicode.be.exception;

import it.epicode.be.model.Utente;

public class RichiestaNotSupportedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// creo l'eccezione per quando la lingua non e supportata 
	
	public RichiestaNotSupportedException(String message, Class<Utente> utente, Exception e) {
		super(message);
	}

}
