package springboot.psp.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class Actor extends DomainEntity{
	
	@NotBlank
	private String nombreUsuario;
	@NotBlank
	private String nombre;
	@NotBlank
	private String apellidos;
	@NotBlank
	private LocalDate fechaNacimiento;
	
	private String fotografia;
	@Email
	@NotBlank
	private String correo;
	@NotBlank
	private String contrasena;
	public Actor(@NotBlank String nombreUsuario,@NotBlank String nombre,@NotBlank String apellidos,@NotBlank LocalDate fechaNacimiento,
			String fotografia,@NotBlank String correo,@NotBlank String contrasena) {
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.fotografia = fotografia;
		this.correo = correo;
		this.contrasena = contrasena;
	}
	public Actor(int id, int version) {
		super(id, version);
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
