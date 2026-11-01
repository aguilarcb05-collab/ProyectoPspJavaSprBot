package springboot.psp.controller;

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

import springboot.psp.entity.Usuario;
import springboot.psp.service.UsuarioService;

@RestController
@RequestMapping("/users")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/register")
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.create(usuario));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable int id) {
		return usuarioService.findById(id)
				.map(u -> ResponseEntity.status(HttpStatus.OK).body(u))
				.orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PutMapping("/{id}/edit")
	public ResponseEntity<Usuario> update(@PathVariable int id, @RequestBody Usuario usuario) {
		Usuario usuarioEditado = usuarioService.update(id, usuario);
		if (usuarioEditado != null) {
			return ResponseEntity.status(HttpStatus.OK).body(usuarioEditado);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@DeleteMapping("/{id}/delete")
	public ResponseEntity<String> delete(@PathVariable int id) {
		if (usuarioService.delete(id)) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
