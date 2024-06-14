package fpdual.nttdata.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fpdual.nttdata.persistencia.Persona;
import fpdual.nttdata.persistencia.PersonaRepositoryI;

/**
 * Servicio de gestión de la FP DUAL.
 */
@Service
public class ServicioGestionImpl implements ServicioGestionI {

	/** Repositorio de personas */
	private PersonaRepositoryI personaRepo;

	/**
	 * Método constructor sobrecargado.
	 * 
	 * @param personaRepo
	 */
	@Autowired
	public ServicioGestionImpl(final PersonaRepositoryI personaRepo) {
		this.personaRepo = personaRepo;
	}

	@Override
	public Page<Persona> obtenerTodasLasPersonas(Pageable pageable) {

		// Consumo del repositorio.
		return personaRepo.findAll(pageable);
	}

	@Override
	public Optional<Persona> obtenerPersonaPorId(final Long idPersona) {

		// Consumo del repositorio.
		return personaRepo.findByIdPersona(idPersona);
	}

	@Override
	public Persona insertarPersona(Persona personaAGuardar) {

		// Consumo del repositorio.
		return personaRepo.save(personaAGuardar);
	}

	@Override
	public Persona actualizarPersona(Persona personaAInsertar) {

		// Consumo del repositorio.
		return personaRepo.save(personaAInsertar);
	}

	@Override
	public void eliminarPersona(Persona personaAEliminar) {

		// Consumo del repositorio.
		personaRepo.delete(personaAEliminar);
	}

}
