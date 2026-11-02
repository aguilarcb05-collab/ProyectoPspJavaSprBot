package springboot.psp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import springboot.psp.entity.Actividad;
import springboot.psp.entity.Administrador;
import springboot.psp.entity.Noticia;
import springboot.psp.entity.Solicitud;
import springboot.psp.entity.TipoEstadoSolicitud;
import springboot.psp.entity.Usuario;
import springboot.psp.repository.ActividadRepository;
import springboot.psp.repository.AdministradorRepository;
import springboot.psp.repository.NoticiaRepository;
import springboot.psp.repository.SolicitudRepository;
import springboot.psp.repository.UsuarioRepository;

@Service
public class AdministradorService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private AdministradorRepository administradorRepository;
	
	//4a
	public List<Usuario> revisarUsuarios() {
        return usuarioRepository.findAll();
    }
	//4a
	public List<Administrador> revisarAdministradores(){
		return administradorRepository.findAll();
	}
	//4a
	public Administrador revisarAdministrador(int idAdminisrador){
		Optional<Administrador> administradorOpcional=administradorRepository.findById(idAdminisrador);
		if(administradorOpcional.isPresent()) {
			return administradorOpcional.get();
		}
		return null;
	}
	
	
}
