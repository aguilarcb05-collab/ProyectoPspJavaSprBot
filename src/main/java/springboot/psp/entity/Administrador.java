package springboot.psp.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class Administrador extends Actor {

	public Administrador() {
		super();
	}

	public Administrador(String nombreUsuario, String nombre, String apellidos, LocalDate fechaNacimiento,
			String fotografia, String correo, String contrasena) {
		super(nombreUsuario, nombre, apellidos, fechaNacimiento, fotografia, correo, contrasena);
	}
}
