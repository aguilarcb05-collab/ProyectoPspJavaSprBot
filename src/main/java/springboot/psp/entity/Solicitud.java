package springboot.psp.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class Solicitud {
	@NotNull
	private LocalDate fechaSolicitud;
	@NotNull
	private TipoEstadoSolicitud tipoSolicitud;
	@NotNull
	private String comentario;
	public Solicitud(@NotNull LocalDate fechaSolicitud, @NotNull TipoEstadoSolicitud tipoSolicitud,
			@NotNull String comentario) {
		super();
		this.fechaSolicitud = fechaSolicitud;
		this.tipoSolicitud = tipoSolicitud;
		this.comentario = comentario;
	}
	public Solicitud() {
		super();
	}
	public LocalDate getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(LocalDate fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	public TipoEstadoSolicitud getTipoSolicitud() {
		return tipoSolicitud;
	}
	public void setTipoSolicitud(TipoEstadoSolicitud tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
}
