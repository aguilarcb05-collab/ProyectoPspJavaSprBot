package springboot.psp.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
public abstract class Actor extends DomainEntity {

	@NotBlank
	@Size(min = 3, max = 50)
	private String nombreUsuario;

	@NotBlank
	private String nombre;

	@NotBlank
	private String apellidos;

	@NotNull
	@Past
	private LocalDate fechaNacimiento;

	// Opcional según requisitos de información
	private String fotografia;

	@NotBlank
	@Email
	private String correo;

	@NotBlank
	@Size(min = 5, max = 100)
	private String contrasena;

	public Actor() {
		super();
	}

	public Actor(String nombreUsuario, String nombre, String apellidos, LocalDate fechaNacimiento, String fotografia,
			String correo, String contrasena) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.fotografia = fotografia;
		this.correo = correo;
		this.contrasena = contrasena;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFotografia() {
		return fotografia;
	}

	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
}
