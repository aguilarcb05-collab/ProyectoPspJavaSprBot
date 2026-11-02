package springboot.psp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.psp.entity.Actividad;
import springboot.psp.service.ActividadService;

@RestController
@RequestMapping("/activities")
public class ActividadController {
	@Autowired
	private ActividadService actividadService;
	
	// REQ 1.b: "Consultar las actividades disponibles y su información"
	@GetMapping
	public ResponseEntity<List<Actividad>> findAll() {
		return ResponseEntity.ok(actividadService.listarActividades());
	}
	// REQ 1.b: ver la información de una actividad concreta.
	@GetMapping("/{id}")
	public ResponseEntity<Actividad> findById(@PathVariable int id) {
		Optional<Actividad> actividadOpt = actividadService.buscarActividad(id);
		if (actividadOpt.isPresent()) {
			return ResponseEntity.ok(actividadOpt.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	// REQ 4.b: "Crear actividad"
	@PostMapping("/create")
	public ResponseEntity<Actividad> create(@RequestBody Actividad a) {
		return ResponseEntity.status(HttpStatus.CREATED).body(actividadService.crearActividad(a));
	}

	// REQ 4.b: "Modificar actividad"
	@PostMapping("/{id}/edit")
	public ResponseEntity<Actividad> update(@PathVariable int id, @RequestBody Actividad a) {
		Actividad editada = actividadService.modificarActividad(id, a);
		if (editada != null) {
			return ResponseEntity.ok(editada);
		}
		return ResponseEntity.notFound().build();
	}

	// REQ 4.b: "Eliminar actividad"
	@PostMapping("/{id}/delete")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		if (actividadService.borrarActividad(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}