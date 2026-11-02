package springboot.psp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.psp.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByNombreUsuario(String nombreUsuario);

	Optional<Usuario> findByCorreo(String correo);

	boolean existsByNombreUsuario(String nombreUsuario);

	boolean existsByCorreo(String correo);
}
