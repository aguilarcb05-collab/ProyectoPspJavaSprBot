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
import springboot.psp.service.SolicitudService;

@RestController
@RequestMapping("/Solicitud")
public class SolicitudController {
    
    @Autowired
    private SolicitudService solicitudService;

    @GetMapping("")
    public ResponseEntity<List<Solicitud>> verSolicitudes() {
        return ResponseEntity.status(HttpStatus.OK).body(solicitudService.listaSolicituds());
    }
    
    @GetMapping("/{idSolicitud}")
    public ResponseEntity<Solicitud> verSolicitud(@PathVariable int idSolicitud){
    	Optional<Solicitud> solicitudOpcional=solicitudService.verSolicitud(idSolicitud);
    	if(solicitudOpcional==null) {
    		return ResponseEntity.status(HttpStatus.OK).build();
    	}
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @PostMapping("/{idUsuario}/{idActividad}")
    public ResponseEntity<Solicitud> crearSolicitud(@PathVariable int idUsuario,@PathVariable int idActividad){
		Solicitud solicitud=solicitudService.crearSolicitudDeInscripcion(idUsuario, idActividad); 
    	if(solicitud==null) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	}
    	return ResponseEntity.status(HttpStatus.CREATED).body(solicitud);
    }
    
    
} 