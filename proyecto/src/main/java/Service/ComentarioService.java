package Service;



import Repository.ComentarioRepository;
import Repository.ActividadRepository;
import Repository.SolicitudRepository; // Repositorio de tu compañero
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Entity.Actividad;
import Entity.Comentario;

import java.util.List;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;
    @Autowired
    private ActividadRepository actividadRepository;
    @Autowired
    private SolicitudRepository solicitudRepository;

    @Transactional
    public Comentario saveComentario(Comentario comentario) {
        Actividad actividad = actividadRepository.findById(comentario.getActividad().getId()).orElse(null);

        if (actividad == null) return null;

        
        if (!actividad.getEstadoActividad().name().equals("FINALIZADA")) {
            return null; 
        }

        
        boolean participo = solicitudRepository.existsByUsuarioIdAndActividadIdAndEstadoSolicitud(
                comentario.getUsuario().getId(), 
                actividad.getId(), 
                TipoEstadoSolicitud.APROBADA 
        );

        if (!participo) return null;

        return comentarioRepository.save(comentario);
    }

    public List<Comentario> getComentariosByActividad(Long actividadId) {
        return comentarioRepository.findByActividadId(actividadId);
    }
}