package springboot.psp.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class Usuario extends Actor{

	public Usuario(String nombreUsuario, String nombre, String apellidos, LocalDate fechaNacimiento, String fotografia,
			String correo, String contrasena) {
		super(nombreUsuario, nombre, apellidos, fechaNacimiento, fotografia, correo, contrasena);
	}
	
}
