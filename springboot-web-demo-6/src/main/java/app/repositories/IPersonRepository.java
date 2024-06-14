
package app.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import app.dto.PersonDto;
import app.entities.Person;

/** Interfaz Repositorio de Personas */
public interface IPersonRepository extends CrudRepository<Person, Long> {

  /**
   * Filtra una lista de personas dado su lenguaje de programación
   * @param programmingLanguage Lenguaje de programación
   * @return List(Person)
   */
  List<Person> findByProgrammingLanguage(String programmingLanguage);

  /**
   * Filtra una lista de personas dado su nombre de pila y su lenguaje de programación
   * @param name                Nombre
   * @param programmingLanguage Lenguaje de programación
   * @return List(Person)
   */
  @Query("SELECT p FROM Person p WHERE p.name = ?1 AND p.programmingLanguage = ?2")
  List<Person> buscarPorNameYProgrammingLanguage(String name, String programmingLanguage);

  /**
   * Obtiene una lista de arrays de datos (nombre y lenguaje de programación)
   * @return List(Object[])
   */
  @Query("SELECT p.name, p.programmingLanguage FROM Person p")
  List<Object[]> obtenerPersonData();

  /**
   * Busca un objeto Person en la DB dado su nombre, el cual debe ser único
   * @param name Nombre
   * @return Optional(Person)
   */
  @Query("SELECT p FROM Person p WHERE p.name = ?1")
  Optional<Person> findOneName(String name);

  /**
   * Busca un objeto Person en la DB dado un patrón de caracteres que debe cumplir su nombre
   * @param namePattern Patrón de caracteres del nombre
   * @return Optional(Person)
   */
  @Query("SELECT p FROM Person p WHERE p.name LIKE %?1%")
  Optional<Person> findOneLikeName(String namePattern);

  /**
   * Busca un nombre dado el ID de la persona
   * @param id ID
   * @return String
   */
  @Query("SELECT p.name FROM Person p WHERE p.id = ?1")
  String getNameById(Long id);

  /** Obtiene todos los datos del DTO PersonDto (nombre y apellidos) */
  @Query("SELECT new PersonDto(p.name, p.lastname FROM Person p")
  List<PersonDto> findAllPersonDto();

}
