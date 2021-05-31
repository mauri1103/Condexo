package it.epicode.be.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.epicode.be.model.Utente;
import it.epicode.be.persistance.UtenteRepository;

@Service
public class UtenteService {

	@Autowired
	UtenteRepository utenteRepo;

	public Optional<Utente> getById(Long id) {
		return utenteRepo.findById(id);
	}
	public Optional<Utente> getByNome(String nome) {
		return utenteRepo.findByNome(nome);
	}
	public List<Utente> getUtenteAll() {
		return utenteRepo.findAll();
	}

	public Utente creaUtente(Utente utente) {
		return utenteRepo.save(utente);

	}
	public Utente updateUtente(Long id) {
		return utenteRepo.getById(id);
		
	}
	public void deleteUtente(Long id) {
		utenteRepo.deleteById(id);
		
		
	}
	public Utente aggiorna(Utente ute) {
		return utenteRepo.save(ute);
	}

	
}