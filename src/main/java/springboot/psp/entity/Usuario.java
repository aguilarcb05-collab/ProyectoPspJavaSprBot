package springboot.psp.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Usuario extends Actor{

	@OneToMany
	private List<Solicitud> solicitudes;

	public Usuario(@NotBlank String nombreUsuario, @NotBlank String nombre, @NotBlank String apellidos,
			@NotNull LocalDate fechaNacimiento, String fotografia, @NotBlank String correo, @NotBlank String contrasena,
			List<Solicitud> solicitudes) {
		super(nombreUsuario, nombre, apellidos, fechaNacimiento, fotografia, correo, contrasena);
		this.solicitudes = solicitudes;
	}

	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}
	
	
	
}
