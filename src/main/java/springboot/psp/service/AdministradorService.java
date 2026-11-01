package springboot.psp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import springboot.psp.entity.Actividad;
import springboot.psp.entity.Administrador;
import springboot.psp.entity.Solicitud;
import springboot.psp.entity.TipoEstadoSolicitud;
import springboot.psp.entity.Usuario;
import springboot.psp.repository.ActividadRepository;
import springboot.psp.repository.AdministradorRepository;
import springboot.psp.repository.SolicitudRepository;
import springboot.psp.repository.UsuarioRepository;

@Service
public class AdministradorService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private AdministradorRepository administradorRepository;
	@Autowired
	private ActividadRepository actividadRepository;
	@Autowired
	private SolicitudRepository solicitudRepository;
	
	public List<Usuario> revisarUsuario(){
		return usuarioRepository.findAll();
	}
	
	
	public List<Administrador> revisarAdministradores(){
		return administradorRepository.findAll();
	}
	
	public List<Actividad> listarActividades(){
		return actividadRepository.findAll();
	}
	
	public Actividad crearActividad(Actividad actividadNueva) {
		return actividadRepository.save(actividadNueva);
	}
	
	@Transactional
	public Actividad modificarActividad(int idActividad, Actividad actividadModificada) {
		Optional<Actividad> actividadOpcional=actividadRepository.findById(idActividad);
		if(actividadOpcional.isPresent()) {
			actividadOpcional.get().setDescripcion(actividadModificada.getDescripcion());
			actividadOpcional.get().setFecha((actividadModificada.getFecha()));
			actividadOpcional.get().setNombre(actividadModificada.getNombre());
			actividadOpcional.get().setHoraInicio(actividadModificada.getHoraInicio());
			actividadOpcional.get().setHoraFinalizacion(actividadModificada.getHoraFinalizacion());
			actividadOpcional.get().setMaximosParticipantes(actividadModificada.getMaximosParticipantes());
			actividadOpcional.get().setUbicacion(actividadModificada.getUbicacion());
			return actividadOpcional.get();
		}
		return null;
		
	}
	
	@Transactional
	public Boolean borrarActividad(int idActividad) {
		Boolean encontrado=false;
		Optional<Actividad> actividadOpcional=actividadRepository.findById(idActividad);
		if(actividadOpcional.isPresent()) {
			actividadRepository.deleteById(idActividad);
			encontrado=true;
		}
		return encontrado;
	}
	
	public List<Solicitud> listaSolicituds(){
		return solicitudRepository.findAll();
	}
	
	@Transactional
	public Solicitud aprobarSolicitud(int idSolicitud, int idActividad) {
	    Optional<Solicitud> solicitudOpcional = solicitudRepository.findById(idSolicitud);
	    Optional<Actividad> actividadOpcional = actividadRepository.findById(idActividad);
	    
	    if (solicitudOpcional.isPresent() && actividadOpcional.isPresent()) {
	        
	        Actividad actividad = actividadOpcional.get();
	        Solicitud s = solicitudOpcional.get();
	        
	        if (actividad.getSolicitudes().contains(s)) {
	            
	            int contadorAprobadas = 0;
	            for (Solicitud solicitudActual : actividad.getSolicitudes()) {
	                if (solicitudActual.getTipoSolicitud().equals(TipoEstadoSolicitud.APROBADA)) {
	                    contadorAprobadas++;
	                }
	            }
	            
	            if (actividad.getMaximosParticipantes() > contadorAprobadas) {
	                
	                // Si no estaba aprobada ya, la aprobamos
	                if (!s.getTipoSolicitud().equals(TipoEstadoSolicitud.APROBADA)) {
	                    s.setTipoSolicitud(TipoEstadoSolicitud.APROBADA);
	                    return s;
	                }
	            }
	        }
	    }
	    
	    // Si algo falla  devuelve null
	    return null;
	}
	
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
	
}
