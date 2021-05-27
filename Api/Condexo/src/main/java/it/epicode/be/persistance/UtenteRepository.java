package it.epicode.be.persistance;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import it.epicode.be.model.Utente;


public interface UtenteRepository extends JpaRepository<Utente, Long> {
	
	

	Optional<Utente> findByNome(String nome);
	
//	Optional<Utente> findByDataDiNascitaBefore(LocalDate before);

	

	
	

}
