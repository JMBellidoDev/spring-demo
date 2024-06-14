package fpdual.nttdata.persistencia;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de T_PERSONA
 */
@Repository
public interface PersonaRepositoryI extends JpaRepository<Persona, Long> {

	/**
	 * Obtiene persona por ID (PK)
	 * 
	 * @param idPersona
	 * @return Optional<Persona>
	 */
	public Optional<Persona> findByIdPersona(final Long idPersona);

}
