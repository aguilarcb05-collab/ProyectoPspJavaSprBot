package springboot.psp.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Solicitud extends DomainEntity {

	@NotNull
	private LocalDate fechaSolicitud;

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoEstadoSolicitud tipoSolicitud;

	@ManyToOne
	private Usuario usuario;

	@ManyToOne
	private Actividad actividad;

	public Solicitud() {
		super();
	}

	public Solicitud(LocalDate fechaSolicitud, TipoEstadoSolicitud tipoSolicitud, Usuario usuario,
			Actividad actividad) {
		super();
		this.fechaSolicitud = fechaSolicitud;
		this.tipoSolicitud = tipoSolicitud;
		this.usuario = usuario;
		this.actividad = actividad;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
}
