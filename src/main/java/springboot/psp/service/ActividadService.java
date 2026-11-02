package springboot.psp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import springboot.psp.entity.Actividad;
import springboot.psp.entity.Solicitud;
import springboot.psp.entity.Usuario;
import springboot.psp.repository.ActividadRepository;
import springboot.psp.repository.AdministradorRepository;
import springboot.psp.repository.SolicitudRepository;
import springboot.psp.repository.UsuarioRepository;

@Service
public class ActividadService {
	
	@Autowired
	ActividadRepository actividadRepository;
	@Autowired
	AdministradorRepository administradorRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	SolicitudRepository solicitudRepository;
	
	//Como no necesitamos saber quien crea las actividades, en el UML administrador no tiene relacion y no se necesita pasar como parametro idAdmin
	
	//4b
	public List<Actividad> listarActividades(){
		return actividadRepository.findAll();
	}
	//4b
	public Actividad crearActividad(Actividad actividadNueva) {
		return actividadRepository.save(actividadNueva);
	}
	//4b
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
	//4b
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
	
	//3b
	//En la actividad pone valoracion, pero creo que se refiere a nuevo comentario y ahí una valoración descriptiva. Por eso pongo este metodo de añadir comentario (Propuesta de Carlos, pd:soy muy listo. Por tanto, en el UML comentario deberia ir dentro de Actividad, no solicitud. Es un error)
	public Actividad añadirComentario(int idActividad,Actividad actividadConComentario,String nuevoComentario) {
		Optional<Actividad> actividadOpcional=actividadRepository.findById(idActividad);
		if(actividadOpcional.isPresent()) {
			actividadOpcional.get().setComentario(nuevoComentario);
			return actividadOpcional.get();
		}
		return null;
	}
	
	//4d
	public String verComentarioDeUsuario(int idActividad, int idUsuario, int idSolicitud) {
	    Optional<Actividad> actividadOpcional = actividadRepository.findById(idActividad);
	    Optional<Solicitud> solicitudOpcional = solicitudRepository.findById(idSolicitud);
	    Optional<Usuario> usuarioOpcional = usuarioRepository.findById(idUsuario);
	    
	    if (actividadOpcional.isPresent() && solicitudOpcional.isPresent() && usuarioOpcional.isPresent()) {
	        Actividad actividad = actividadOpcional.get();
	        Solicitud solicitud = solicitudOpcional.get();
	        Usuario usuario = usuarioOpcional.get();
	        
	        // Validamos las relaciones comparando los IDs de los objetos vinculados
	        boolean esDelUsuario = (solicitud.getUsuario().getId() == usuario.getId());
	        boolean esDeLaActividad = (solicitud.getActividad().getId() == actividad.getId());
	        boolean laActividadContieneSolicitud = actividad.getSolicitudes().contains(solicitud);
	        
	        if (esDelUsuario && esDeLaActividad && laActividadContieneSolicitud) {
	            return "Comentario del usuario " + usuario.getNombre() + ": " + actividad.getComentario();
	        }
	    }
	    
	    return "No se encontraron los datos";
	}
}
