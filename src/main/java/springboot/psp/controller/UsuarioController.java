package springboot.psp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import springboot.psp.entity.Usuario;
import springboot.psp.service.UsuarioService;

@RestController
@RequestMapping("/users")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	// REQ 1.a: "Registrarse en el sistema"
	@PostMapping("/register")
	public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario usuario) {
		Usuario creado = usuarioService.create(usuario);
		if (creado != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(creado);
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}

	// REQ 2.b: "Consultar sus datos personales"
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable int id) {
		Optional<Usuario> usuarioOpt = usuarioService.findById(id);
		if (usuarioOpt.isPresent()) {
			return ResponseEntity.ok(usuarioOpt.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	// REQ 2.c: "Exportar sus datos personales"
	@GetMapping("/{id}/export")
	public ResponseEntity<Usuario> exportarDatos(@PathVariable int id) {
		Optional<Usuario> usuarioOpt = usuarioService.exportarDatos(id);
		if (usuarioOpt.isPresent()) {
			return ResponseEntity.ok(usuarioOpt.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	// REQ 2.b: "Editar sus datos personales"
	@PutMapping("/{id}/edit")
	public ResponseEntity<Usuario> update(@PathVariable int id, @Valid @RequestBody Usuario usuario) {
		if (usuarioService.findById(id).isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		Usuario editado = usuarioService.update(id, usuario);
		if (editado != null) {
			return ResponseEntity.ok(editado);
		}
		// nombreUsuario o correo ya usados por otro usuario
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}

	// REQ 2.c: "Solicitar la eliminación de su perfil"
	@DeleteMapping("/{id}/delete")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		if (usuarioService.delete(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
