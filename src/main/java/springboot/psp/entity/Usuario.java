package springboot.psp.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario extends Actor {

	@OneToMany(mappedBy = "usuario")
	private List<Solicitud> solicitudes = new ArrayList<>();

	public Usuario() {
		super();
	}

	public Usuario(String nombreUsuario, String nombre, String apellidos, LocalDate fechaNacimiento, String fotografia,
			String correo, String contrasena) {
		super(nombreUsuario, nombre, apellidos, fechaNacimiento, fotografia, correo, contrasena);
	}

	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}
}
