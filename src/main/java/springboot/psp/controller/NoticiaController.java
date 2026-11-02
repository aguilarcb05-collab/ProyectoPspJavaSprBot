package springboot.psp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import springboot.psp.entity.Noticia;
import springboot.psp.service.NoticiaService;

@RestController
@RequestMapping("/news")
public class NoticiaController {
	@Autowired
	private NoticiaService noticiaService;
	
	// REQ 1.c: "Acceder a las noticias publicadas"
	@GetMapping
	public ResponseEntity<List<Noticia>> findAll() {
		return ResponseEntity.ok(noticiaService.findByAll());
	}
	// REQ 1.c: ver una noticia concreta.
	@GetMapping("/{id}")
	public ResponseEntity<Noticia> findById(@PathVariable int id) {
		return noticiaService.findById(id).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	// REQ 4.e:Crear noticia
	@PostMapping("/create")
	public ResponseEntity<Noticia> create(@Valid @RequestBody Noticia n) {
		return ResponseEntity.status(HttpStatus.CREATED).body(noticiaService.create(n));
	}
	// REQ 4.e:Modificar noticia
	@PostMapping("/{id}/edit")
	public ResponseEntity<Noticia> update(@PathVariable int id, @Valid @RequestBody Noticia n) {
		Noticia editada = noticiaService.update(n, id);
		if (editada != null) {
			return ResponseEntity.ok(editada);
		}
		return ResponseEntity.notFound().build();
	}
	// REQ 4.e:Eliminar noticia
	@PostMapping("/{id}/delete")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		if (noticiaService.delete(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
