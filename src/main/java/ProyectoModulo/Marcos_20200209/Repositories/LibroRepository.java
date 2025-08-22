package ProyectoModulo.Marcos_20200209.Repositories;

import ProyectoModulo.Marcos_20200209.Entities.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<LibroEntity, Long>{}

