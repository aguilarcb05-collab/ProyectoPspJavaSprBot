package springboot.psp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.psp.entity.Solicitud;
@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Integer>{

}
