package springboot.psp.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Actividad extends DomainEntity {
	@NotBlank
	private String nombre;
	@NotBlank
	private String descripcion;
	@NotNull
	private LocalDate fecha;
	@NotNull
	private LocalDateTime horaInicio;
	@NotNull
	private LocalDateTime horaFinalizacion;
	@NotBlank
	private String ubicacion;
	@Min(1)
	private int maximosParticipantes;
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoEstadoActividad estadoActividad;
	
	public Actividad() {
		super();
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	public LocalDateTime getHoraFinalizacion() {
		return horaFinalizacion;
	}
	public void setHoraFinalizacion(LocalDateTime horaFinalizacion) {
		this.horaFinalizacion = horaFinalizacion;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public int getMaximosParticipantes() {
		return maximosParticipantes;
	}
	public void setMaximosParticipantes(int maximosParticipantes) {
		this.maximosParticipantes = maximosParticipantes;
	}
	public TipoEstadoActividad getEstadoActividad() {
		return estadoActividad;
	}
	public void setEstadoActividad(TipoEstadoActividad estadoActividad) {
		this.estadoActividad = estadoActividad;
	}
	
	
}
