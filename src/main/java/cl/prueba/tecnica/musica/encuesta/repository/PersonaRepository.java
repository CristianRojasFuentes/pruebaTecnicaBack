package cl.prueba.tecnica.musica.encuesta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.prueba.tecnica.musica.encuesta.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{
	
}
