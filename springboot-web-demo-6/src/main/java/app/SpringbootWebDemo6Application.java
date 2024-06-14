
package app;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import app.entities.Person;
import app.repositories.IPersonRepository;

/** Clase principal */
@SpringBootApplication
public class SpringbootWebDemo6Application implements CommandLineRunner {

  /** Person Repository */
  private IPersonRepository repository;

  /**
   * Constructor
   * @param repository Repositorio de personas
   */
  @Autowired
  public SpringbootWebDemo6Application(IPersonRepository repository) {
    this.repository = repository;
  }

  /**
   * Método main
   * @param args Argumentos
   */
  public static void main(String[] args) {
    SpringApplication.run(SpringbootWebDemo6Application.class, args);
  }

  @Override
  @Transactional(propagation = Propagation.NESTED)
  public void run(String... args) throws Exception {

    // Consultas - Listas
    List<Person> people = repository.findByProgrammingLanguage("Java");
    people.stream().forEach(System.out::println);

    List<Person> people2 = repository.buscarPorNameYProgrammingLanguage("Maria", "Java");
    people2.stream().forEach(System.out::println);

    List<Object[]> peopleData = repository.obtenerPersonData();
    peopleData.stream().forEach(p -> System.out.println(String.format("%s - %s", p[0], p[1])));

    // Consultas - Optional<Person>
    findPerson();

    // Inserciones
    insert();

    // Actualizaciones
    update();

    // Eliminaciones
    delete();

  }

  /** Realiza consultas de una sola persona */
  @Transactional(readOnly = true)
  public void findPerson() {

    repository.findById(1L).ifPresent(System.out::println);
    repository.findOneName("Andres").ifPresent(System.out::println);
    repository.findOneLikeName("And").ifPresent(System.out::println);
  }

  /** Realiza inserciones */
  @Transactional
  public void insert() {
    Person person = new Person(null, "Pablo", "Escobar", "Python");
    Person person2 = new Person(null, "Matías", "Toledo", "Javascript");

    person = repository.save(person);
    person2 = repository.save(person2);

    System.out.println(String.format("Saved - %s", person));
    System.out.println(String.format("Saved - %s", person2));
  }

  /** Realiza actualizaciones */
  @Transactional
  public void update() {

    Optional<Person> optionalPerson = repository.findById(2L);

    optionalPerson.ifPresent(person -> {

      person.setProgrammingLanguage("HTML/CSS");
      repository.save(person);

    });
  }

  /** Realiza eliminaciones */
  @Transactional
  public void delete() {

    repository.deleteById(4L);

    Optional<Person> optPerson = repository.findById(6L);
    optPerson.ifPresentOrElse(repository::delete, () -> System.out.println("No existe la persona"));

  }

}
