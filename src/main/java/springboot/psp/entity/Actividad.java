package springboot.psp.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Actividad extends DomainEntity{

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

    @NotNull
    private String ubicacion;

    @NotNull
    private int maximosParticipantes;

    @NotBlank
    private TipoEstadoActividad estadoActividad;
    
    private List<Solicitud> solicitudes;

    

	

	public Actividad() {
    }

    

    

	public Actividad(int id, int version, @NotBlank String nombre, @NotBlank String descripcion,
			@NotNull LocalDate fecha, @NotNull LocalDateTime horaInicio, @NotNull LocalDateTime horaFinalizacion,
			@NotNull String ubicacion, @NotNull int maximosParticipantes, @NotBlank TipoEstadoActividad estadoActividad,
			List<Solicitud> solicitudes) {
		super(id, version);
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFinalizacion = horaFinalizacion;
		this.ubicacion = ubicacion;
		this.maximosParticipantes = maximosParticipantes;
		this.estadoActividad = estadoActividad;
		this.solicitudes = solicitudes;
	}





	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}





	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
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
