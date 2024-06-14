package fpdual.nttdata.controladores;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fpdual.nttdata.persistencia.Persona;
import fpdual.nttdata.servicios.ServicioGestionI;

/**
 * Controlador de FP Dual.
 */
@RestController
@RequestMapping("/api/alumnado")
public class ControladorPrincipal {

	/** Servicio de gestión */
	private ServicioGestionI servicioGestion;

	/**
	 * Método constructor sobrecargado
	 * 
	 * @param servicioGestion
	 */
	@Autowired
	public ControladorPrincipal(final ServicioGestionI servicioGestion) {
		this.servicioGestion = servicioGestion;
	}

	/**
	 * Guarda una persona
	 * 
	 * @param pGuardar
	 * @return ResponseEntity<Persona>
	 */
	@PostMapping
	public ResponseEntity<Persona> postPersona(final @RequestBody Persona pGuardar) {

		// Guarda la persona consumiendo el servicio.
		final Persona pGuardada = servicioGestion.insertarPersona(pGuardar);

		// Retorna la ubicación de la persona en el sistema.
		final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(pGuardada.getIdPersona()).toUri();

		return ResponseEntity.created(location).body(pGuardada);

	}

	/**
	 * Actualiza una persona
	 * 
	 * @param id
	 * @param pActualizar
	 * @return ResponseEntity<Persona>
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Persona> putPersona(final @PathVariable Long id, final @RequestBody Persona pActualizar) {

		// Resultado
		ResponseEntity<Persona> pActualizada = ResponseEntity.unprocessableEntity().build();

		// Obtención de la persona por ID (PK)
		final Optional<Persona> pEncontrada = servicioGestion.obtenerPersonaPorId(id);

		// Persona obtenida
		if (pEncontrada.isPresent()) {

			// Actualización
			pActualizar.setIdPersona(pEncontrada.get().getIdPersona());
			servicioGestion.actualizarPersona(pActualizar);

			// Resultado
			pActualizada = ResponseEntity.noContent().build();
		}

		return pActualizada;

	}

	/**
	 * Elimina una persona
	 * 
	 * @param id
	 * @return ResponseEntity<Persona>
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Persona> deletePersona(final @PathVariable Long id) {

		// Resultado
		ResponseEntity<Persona> pEliminada = ResponseEntity.unprocessableEntity().build();

		// Obtención de la persona por ID (PK)
		final Optional<Persona> pEncontrada = servicioGestion.obtenerPersonaPorId(id);

		// Persona obtenida
		if (pEncontrada.isPresent()) {

			// Eliminar
			servicioGestion.actualizarPersona(pEncontrada.get());

			// Resultado
			pEliminada = ResponseEntity.noContent().build();
		}

		return pEliminada;

	}

	/**
	 * Obtiene todas las personas
	 * 
	 * @param pageable
	 * @return ResponseEntity<Page<Persona>>
	 */
	@GetMapping
	public ResponseEntity<Page<Persona>> consultarTodasPersonas(final Pageable pageable) {

		// Obtención de todas las personas
		return ResponseEntity.ok(servicioGestion.obtenerTodasLasPersonas(pageable));

	}

	@GetMapping(path = "id/{id}")
	public ResponseEntity<Persona> consultarPersonaPorId(final @PathVariable Long id) {

		// Resultado
		ResponseEntity<Persona> pResponse = ResponseEntity.unprocessableEntity().build();

		// Obtención de la persona por ID (PK)
		final Optional<Persona> pEncontrada = servicioGestion.obtenerPersonaPorId(id);

		// Persona obtenida
		if (pEncontrada.isPresent()) {
			pResponse = ResponseEntity.ok(pEncontrada.get());
		}

		return pResponse;

	}

}
