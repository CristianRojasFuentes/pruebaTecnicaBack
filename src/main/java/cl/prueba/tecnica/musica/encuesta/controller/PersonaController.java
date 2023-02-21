package cl.prueba.tecnica.musica.encuesta.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.prueba.tecnica.musica.encuesta.exception.ResourceNotFoundException;
import cl.prueba.tecnica.musica.encuesta.model.Persona;
import cl.prueba.tecnica.musica.encuesta.repository.PersonaRepository;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {

	@Autowired
	private PersonaRepository repository;
	
	@GetMapping("/obtienePersona")
	public List<Persona> getPersona(){
		return repository.findAll();
	}
	
	@PostMapping("/persona")
	public Persona createPersona(@Validated @RequestBody Persona persona ) {
		return repository.save(persona);
	}
	
	@GetMapping("/persona/{id}")
	public ResponseEntity< Persona> obtenerPErsonaId(@PathVariable(value = "id") Long idPersona) throws ResourceNotFoundException {
		
		Persona persona = repository.findById(idPersona).orElseThrow(() -> new ResourceNotFoundException("No se encuentra esta persona :: " + idPersona)); 
		
		return ResponseEntity.ok().body(persona);
	}
	
	@PutMapping("/persona/{id}")
	public ResponseEntity<Persona> actualizarPersona(@PathVariable(value = "id") Long idPersona,
			@Validated @RequestBody Persona personaDetalle ) throws ResourceNotFoundException {
		
		Persona p = repository.findById(idPersona).orElseThrow(() -> new ResourceNotFoundException("No se encuentra esta persona :: " + idPersona));
		
		p.setEmail(personaDetalle.getEmail());
		p.setEstilo(personaDetalle.getEstilo());
		
		final Persona actualizaPersona = repository.save(p);
		return ResponseEntity.ok(actualizaPersona);
		
	}
	
	@DeleteMapping("/persona/{id}")
	public Map<String, Boolean> eliminarPersona(@PathVariable(value = "id") Long idPersona) throws ResourceNotFoundException {
		
		Persona persona = repository.findById(idPersona).orElseThrow(() -> new ResourceNotFoundException("No se encuentra esta persona :: " + idPersona));
		
		repository.delete(persona);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
		
	}
	
}
