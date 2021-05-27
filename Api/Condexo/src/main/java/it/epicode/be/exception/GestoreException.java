package it.epicode.be.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class GestoreException extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(RichiestaNotSupportedException.class)
	protected ResponseEntity<ErroreMessaggio> gestioneEccezione (RichiestaNotSupportedException ex){
		
		ErroreMessaggio errP = new ErroreMessaggio();
		errP.setStato(HttpStatus.INTERNAL_SERVER_ERROR);
		errP.setMessaggio(PAGE_NOT_FOUND_LOG_CATEGORY + " " +  errP.getDeveloper_reference());
		
		return new ResponseEntity<ErroreMessaggio>(errP,errP.getStato());
		
		
	
		
	}
	
	
	
	
}
