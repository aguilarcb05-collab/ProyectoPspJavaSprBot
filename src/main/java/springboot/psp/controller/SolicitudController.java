package springboot.psp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.psp.entity.Solicitud;
import springboot.psp.entity.TipoEstadoSolicitud;
import springboot.psp.service.SolicitudService;

@RestController
@RequestMapping("/Solicitud")
public class SolicitudController {

	@Autowired
	private SolicitudService solicitudService;

	// REQ 4.c: consultar solicitudes
	@GetMapping("")
	public ResponseEntity<List<Solicitud>> verSolicitudes() {
		return ResponseEntity.status(HttpStatus.OK).body(solicitudService.listaSolicituds());
	}

	// REQ 4.c: consultar una solicitud
	@GetMapping("/{idSolicitud}")
	public ResponseEntity<Solicitud> verSolicitud(@PathVariable int idSolicitud) {
		Optional<Solicitud> solicitudOpcional = solicitudService.verSolicitud(idSolicitud);
		if (solicitudOpcional.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(solicitudOpcional.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	// REQ 3.a: consultar estado de una solicitud
	@GetMapping("/{idSolicitud}/estado")
	public ResponseEntity<TipoEstadoSolicitud> consultarEstado(@PathVariable int idSolicitud) {
		TipoEstadoSolicitud estado = solicitudService.consultarTipoSolicitud(idSolicitud);
		if (estado != null) {
			return ResponseEntity.status(HttpStatus.OK).body(estado);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	// REQ 3.a: solicitar inscripción
	@PostMapping("/{idUsuario}/{idActividad}")
	public ResponseEntity<Solicitud> crearSolicitud(@PathVariable int idUsuario, @PathVariable int idActividad) {
		Solicitud solicitud = solicitudService.crearSolicitudDeInscripcion(idUsuario, idActividad);
		if (solicitud == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(solicitud);
	}

	// REQ 3.a: cancelar solicitud PENDIENTE
	@PostMapping("/{idSolicitud}/cancel/{idUsuario}")
	public ResponseEntity<Solicitud> cancelarSolicitud(@PathVariable int idSolicitud, @PathVariable int idUsuario) {
		Solicitud cancelada = solicitudService.cancelarSolicitud(idSolicitud, idUsuario);
		if (cancelada != null) {
			return ResponseEntity.status(HttpStatus.OK).body(cancelada);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	// REQ 4.c: aprobar solicitud
	@PostMapping("/{idSolicitud}/approve/{idActividad}")
	public ResponseEntity<Solicitud> aprobarSolicitud(@PathVariable int idSolicitud, @PathVariable int idActividad) {
		Solicitud aprobada = solicitudService.aprobarSolicitudPorAdmin(idSolicitud, idActividad);
		if (aprobada != null) {
			return ResponseEntity.status(HttpStatus.OK).body(aprobada);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	// REQ 4.c: rechazar solicitud
	@PostMapping("/{idSolicitud}/reject")
	public ResponseEntity<Solicitud> rechazarSolicitud(@PathVariable int idSolicitud) {
		Solicitud rechazada = solicitudService.rechazarSolicitud(idSolicitud);
		if (rechazada != null) {
			return ResponseEntity.status(HttpStatus.OK).body(rechazada);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}
