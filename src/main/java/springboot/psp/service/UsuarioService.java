package springboot.psp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import springboot.psp.entity.Usuario;
import springboot.psp.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	// RQFUNCIONAL: 1a "Registrarse en el sistema"
	public Usuario create(Usuario usuario) {
		if (usuarioRepository.existsByNombreUsuario(usuario.getNombreUsuario())
				|| usuarioRepository.existsByCorreo(usuario.getCorreo())) {
			return null;
		}
		return usuarioRepository.save(usuario);
	}

	// RQFUNCIONAL: 2b "Consultar sus datos personales"
	public Optional<Usuario> findById(int id) {
		return usuarioRepository.findById(id);
	}

	// RQFUNCIONAL: 2c "Exportar sus datos personales"
	public Optional<Usuario> exportarDatos(int id) {
		return usuarioRepository.findById(id);
	}

	// RQFUNCIONAL: 2b "Editar sus datos personales"
	// Devuelve null si hay conflicto de nombreUsuario/correo con otro usuario.
	@Transactional
	public Usuario update(int idUsuario, Usuario usuarioEditado) {
		Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
		if (usuario == null) {
			return null;
		}

		Optional<Usuario> porNombre = usuarioRepository.findByNombreUsuario(usuarioEditado.getNombreUsuario());
		if (porNombre.isPresent() && porNombre.get().getId() != idUsuario) {
			return null;
		}

		Optional<Usuario> porCorreo = usuarioRepository.findByCorreo(usuarioEditado.getCorreo());
		if (porCorreo.isPresent() && porCorreo.get().getId() != idUsuario) {
			return null;
		}

		usuario.setNombreUsuario(usuarioEditado.getNombreUsuario());
		usuario.setNombre(usuarioEditado.getNombre());
		usuario.setApellidos(usuarioEditado.getApellidos());
		usuario.setFechaNacimiento(usuarioEditado.getFechaNacimiento());
		usuario.setFotografia(usuarioEditado.getFotografia());
		usuario.setCorreo(usuarioEditado.getCorreo());
		usuario.setContrasena(usuarioEditado.getContrasena());

		return usuarioRepository.save(usuario);
	}

	// RQFUNCIONAL: 2c "Solicitar la eliminación de su perfil"
	@Transactional
	public boolean delete(int idUsuario) {
		if (usuarioRepository.existsById(idUsuario)) {
			usuarioRepository.deleteById(idUsuario);
			return true;
		}
		return false;
	}
}
