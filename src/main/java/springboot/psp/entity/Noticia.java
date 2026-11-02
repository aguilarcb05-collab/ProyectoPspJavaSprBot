package springboot.psp.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Noticia {

	@NotBlank
	private String titulo;
	@NotBlank
	private String contenido;
	@NotNull
	private LocalDate fechaPublicacion;
	
	private String imagen;
	public Noticia(@NotBlank String titulo, @NotBlank String contenido, @NotNull LocalDate fechaPublicacion,
			@NotBlank String imagen) {
		super();
		this.titulo = titulo;
		this.contenido = contenido;
		this.fechaPublicacion = fechaPublicacion;
		this.imagen = imagen;
	}
	public Noticia() {
		super();
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}
	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
}
