package springboot.psp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.psp.entity.Usuario;
import springboot.psp.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario create(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Optional<Usuario> findById(int id) {
		return usuarioRepository.findById(id);
	}

	@Transactional
	public Usuario update(int idUsuario, Usuario usuarioEditado) {
		Optional<Usuario> usuarioOpt = findById(idUsuario);
		if (usuarioOpt.isPresent()) {
			Usuario usuario = usuarioOpt.get();
			usuario.setNombreUsuario(usuarioEditado.getNombreUsuario());
			usuario.setNombre(usuarioEditado.getNombre());
			usuario.setApellidos(usuarioEditado.getApellidos());
			usuario.setFechaNacimiento(usuarioEditado.getFechaNacimiento());
			usuario.setFotografia(usuarioEditado.getFotografia());
			usuario.setCorreo(usuarioEditado.getCorreo());
			usuario.setContrasena(usuarioEditado.getContrasena());
			return usuarioRepository.save(usuario);
		}
		return null;
	}

	@Transactional
	public boolean delete(int idUsuario) {
		Optional<Usuario> usuarioOpt = findById(idUsuario);
		if (usuarioOpt.isPresent()) {
			usuarioRepository.deleteById(idUsuario);
			return true;
		}
		return false;
	}
}
