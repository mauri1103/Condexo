package it.epicode.be.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be.exception.RichiestaNotSupportedException;
import it.epicode.be.model.Utente;
import it.epicode.be.service.UtenteService;

@RestController
@RequestMapping("/api")
public class UtenteController {

	@Autowired
	UtenteService utenteService;

	@GetMapping("/utenteFormat")
	public Utente utenteFormat() {
		Utente utente = new Utente(); // Creo un form base di un Utente
		utente.setId(1l);
		utente.setUsers("Jhonny47");
		utente.setNome("Alessandro");
		utente.setCognome("Magno");
		utente.setData_di_nascita(LocalDate.of(1994, 03, 11));
		utente.setEmail("Alessandro.Magno@gmail.com");
		return utente;
	}

//  metodo per richiamare un utente tramite il suo id 
	@GetMapping("/utente/{id}")
	public ResponseEntity<Utente> getByIdUtente(@PathVariable(required = true) Long id) {

		Optional<Utente> result = utenteService.getById(id);

		if (result.isPresent()) {
			return new ResponseEntity<Utente>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Utente>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/nomeUtente/{nome}") // Recupero l'utente tramite il nome
	public ResponseEntity<Utente> nomeUtente(@PathVariable(required = true) String nome) {
		try {
			Optional<Utente> result = utenteService.getByNome(nome);
			if (result.isEmpty()) {
				return new ResponseEntity<Utente>(HttpStatus.NOT_FOUND);
			}else {
				return new ResponseEntity<Utente>(result.get(), HttpStatus.OK);
			}
		} catch (Exception e) {
			throw new RichiestaNotSupportedException("Utente non disponibile", Utente.class,e);
		}
		

		

	}

//  Get usata per richiamare la lista completa degli utenti 
	@GetMapping("/utenteAll")
	public ResponseEntity<List<Utente>> utenteAll() {
		try {
			List<Utente> listaUtente = utenteService.getUtenteAll();
			if(listaUtente.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(listaUtente, HttpStatus.OK);
			}
		} catch (Exception e) {
			throw new RichiestaNotSupportedException("Non e presente nessuna lista", Utente.class,e);
		}
		
	}

	
// Post usato per creare un utente tramite il body
	@PostMapping(value = "/creaUtente", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Utente> creaUtente(@RequestBody Utente utente) {
		try {
			Utente cUtente = utenteService.creaUtente(utente);
			return new ResponseEntity<>(cUtente, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new RichiestaNotSupportedException("Utente non creato", Utente.class,e);
		}

	}

// Put per aggiornare un utente
	@PutMapping(value = "/aggiornaUtente", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Utente> aggiornaUtente(@RequestBody Utente utente) {
		try {
			Utente aggUtente = utenteService.updateUtente(utente);
			if (aggUtente != null) {
				return new ResponseEntity<>(aggUtente, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			throw new RichiestaNotSupportedException("Utente non aggiornato", Utente.class,e);

		}

	}

//  Delete per eliminare un utente atraverso il suo Id
	@DeleteMapping(value = "/eliminaUtente/{id}")
	public ResponseEntity<String> eliminaUtente(@PathVariable("id") Long id) {
		try {
			utenteService.deleteUtente(id);
			return new ResponseEntity<String>("L'utente selezionato e stato eliminato ", HttpStatus.NO_CONTENT);
			
		} catch (Exception e) {
			throw new RichiestaNotSupportedException("Utente non eliminato", Utente.class,e);
		}

	}

}
