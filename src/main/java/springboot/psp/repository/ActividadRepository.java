package springboot.psp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.psp.entity.Actividad;
@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Integer>{

}
