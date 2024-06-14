package fpdual.nttdata.servicios;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fpdual.nttdata.persistencia.Persona;

/**
 * Servicio de gestión de la FP DUAL.
 */
public interface ServicioGestionI {

	/**
	 * Método para obtener todas las personas.
	 * 
	 * @param pageable
	 * @return Page<Persona>
	 */
	public Page<Persona> obtenerTodasLasPersonas(final Pageable pageable);

	/**
	 * Método para obtener persona por ID.
	 */
	public Optional<Persona> obtenerPersonaPorId(final Long idPersona);

	/**
	 * Método para insertar persona.
	 * 
	 * @param personaAGuardar
	 * @return Persona
	 */
	public Persona insertarPersona(final Persona personaAGuardar);

	/**
	 * Método para actualizar persona.
	 * 
	 * @param personaAActualizar
	 * @return Persona
	 */
	public Persona actualizarPersona(final Persona personaAInsertar);
	
	/**
	 * Método para eliminar persona.
	 * 
	 * @param personaAEliminar
	 */
	public void eliminarPersona(final Persona personaAEliminar);
	
	

}
