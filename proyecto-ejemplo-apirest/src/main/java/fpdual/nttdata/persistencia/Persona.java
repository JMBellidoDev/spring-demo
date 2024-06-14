package fpdual.nttdata.persistencia;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entidad que representa a la tabla Persona
 * 
 * @author NTT DATA
 */
@Entity
@Table(name = "T_PERSONA")
@Data
public class Persona implements Serializable {

	/** Serial UID */
	private static final long serialVersionUID = 1L;

	/** ID Persona (PK) */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_ID_PERSONA")
	private Long idPersona;

	/** Nombre */
	@Column(name = "C_NOMBRE")
	private String nombre;

	/** False DAM / True DAW */
	@Column(name = "C_DAW")
	private boolean daw;

}
