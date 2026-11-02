package springboot.psp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import springboot.psp.entity.Actividad;
import springboot.psp.entity.Solicitud;
import springboot.psp.entity.TipoEstadoSolicitud;
import springboot.psp.entity.Usuario;
import springboot.psp.repository.ActividadRepository;
import springboot.psp.repository.SolicitudRepository;
import springboot.psp.repository.UsuarioRepository;

@Service
public class SolicitudService {
	@Autowired
	SolicitudRepository solicitudRepository;
	@Autowired
	ActividadRepository actividadRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	
	//4c
	public List<Solicitud> listaSolicituds(){
		return solicitudRepository.findAll();
	}
	//4c
	public Optional<Solicitud> verSolicitud(int idSolicitud){
		return solicitudRepository.findById(idSolicitud);
	}
	
	//4c
	@Transactional
	public Solicitud aprobarSolicitudPorAdmin(int idSolicitud, int idActividad) {
	    Optional<Solicitud> solicitudOpcional = solicitudRepository.findById(idSolicitud);
	    Optional<Actividad> actividadOpcional = actividadRepository.findById(idActividad);
	    
	    if (solicitudOpcional.isPresent() && actividadOpcional.isPresent()) {
	        
	        Actividad actividad = actividadOpcional.get();
	        Solicitud s = solicitudOpcional.get();
	        
	        if (s.getActividad() != null && s.getActividad().getId() == actividad.getId()) {

	            int contadorAprobadas = 0;
	            for (Solicitud solicitudActual : actividad.getSolicitudes()) {
	                if (solicitudActual.getTipoSolicitud().equals(TipoEstadoSolicitud.APROBADA)) {
	                    contadorAprobadas++;
	                }
	            }

	            if (actividad.getMaximosParticipantes() > contadorAprobadas
	            		&& s.getTipoSolicitud().equals(TipoEstadoSolicitud.PENDIENTE)) {
	                s.setTipoSolicitud(TipoEstadoSolicitud.APROBADA);
	                return s;
	            }
	        }
	    }
	    
	    // Si algo falla  devuelve null
	    return null;
	}
	
	//4c
	@Transactional
	public Solicitud rechazarSolicitud(int idSolicitud) {
		Optional <Solicitud> solicitudOpcional=solicitudRepository.findById(idSolicitud);
		if(solicitudOpcional.isPresent()) {
			Solicitud s=solicitudOpcional.get();
			if(!s.getTipoSolicitud().equals(TipoEstadoSolicitud.RECHAZADA)) {
				s.setTipoSolicitud(TipoEstadoSolicitud.RECHAZADA);
				return s;
			}
		}
		return null;
	}
	
	//3a
	@Transactional
	public TipoEstadoSolicitud consultarTipoSolicitud(int idSolicitud) {
		Optional<Solicitud> solicitudOpcional=solicitudRepository.findById(idSolicitud);
		if(solicitudOpcional.isPresent()) {
			return solicitudOpcional.get().getTipoSolicitud();
		}
		return null;
	}
	
	//3a
	@Transactional
	public Solicitud cancelarSolicitud(int idSolicitud, int idUsuario) {
		Optional <Solicitud> solicitudOpcional=solicitudRepository.findById(idSolicitud);
		Optional<Usuario> usuarioOpcional=usuarioRepository.findById(idUsuario);
		if(solicitudOpcional.isPresent()&&usuarioOpcional.isPresent()) {
			Solicitud s=solicitudOpcional.get();
			if(s.getTipoSolicitud().equals(TipoEstadoSolicitud.PENDIENTE)) {
				s.setTipoSolicitud(TipoEstadoSolicitud.RECHAZADA);
				return s;
			}
		}
		return null;
	}
	
	//3a
	@Transactional
	public Solicitud crearSolicitudDeInscripcion(int idUsuario, int idActividad) {
		Optional<Usuario> usuarioOpcional = usuarioRepository.findById(idUsuario);
		Optional<Actividad> actividadOpcional = actividadRepository.findById(idActividad);
		if (usuarioOpcional.isPresent() && actividadOpcional.isPresent()) {
			Solicitud solicitudNueva = new Solicitud(LocalDate.now(), TipoEstadoSolicitud.PENDIENTE,
					usuarioOpcional.get(), actividadOpcional.get());
			return solicitudRepository.save(solicitudNueva);
		}
		return null;
	}
}
