package springboot.psp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.psp.entity.Administrador;
import springboot.psp.service.AdministradorService;

@RestController
@RequestMapping("/users/Admin")
public class AdministradorController {
	@Autowired
	AdministradorService administradorService;
	
	@GetMapping("")
	public ResponseEntity<List<Administrador>> administradores(){
		return ResponseEntity.status(HttpStatus.OK).body(administradorService.revisarAdministradores());
	}
	
	@GetMapping("/{idAdministrador}")
	public ResponseEntity<Administrador> administrador(int idAdministrador){
		Administrador administradorEncontrado=administradorService.revisarAdministrador(idAdministrador);
		if(administradorEncontrado==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(administradorEncontrado);
	}
}
