package it.epicode.be.persistance;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import it.epicode.be.model.Utente;


public interface UtenteRepository extends JpaRepository<Utente, Long> {
	
	

	public Optional<Utente> findByNome(String nome);

	

	
	

}
