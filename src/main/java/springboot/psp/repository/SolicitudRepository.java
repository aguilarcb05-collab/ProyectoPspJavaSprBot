package springboot.psp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.psp.entity.Actividad;
import springboot.psp.entity.Solicitud;
import springboot.psp.entity.Usuario;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {

	boolean existsByUsuarioAndActividad(Usuario usuario, Actividad actividad);
}
