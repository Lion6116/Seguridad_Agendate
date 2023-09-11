package tutorial.misonTIC.seguridad.Repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import tutorial.misonTIC.seguridad.Modelos.Rol;

public interface RepositorioRol extends MongoRepository<Rol,String> {
}
