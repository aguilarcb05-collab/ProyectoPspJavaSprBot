package springboot.psp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import springboot.psp.entity.Noticia;
import springboot.psp.repository.NoticiaRepository;

@Service
public class NoticiaService {
	@Autowired
	NoticiaRepository noticiaRepository;
	//4e
	@Transactional
	public List<Noticia> listaNoticias() {
		return noticiaRepository.findAll();
	}
	
	//4e
	public Optional<Noticia> verNoticia(int idNoticia){
		return noticiaRepository.findById(idNoticia);
	}
	//4e
	public Noticia crearNoticia(Noticia noticiaNueva) {
		return noticiaRepository.save(noticiaNueva);
	}
	//4e
	@Transactional
	public Noticia modificarNoticia(int idNoticia, Noticia noticiaModificada) {
		Optional<Noticia> noticiaOpcional=noticiaRepository.findById(idNoticia);
		if(noticiaOpcional.isPresent()) {
			noticiaOpcional.get().setTitulo(noticiaModificada.getTitulo());
			noticiaOpcional.get().setContenido(noticiaModificada.getContenido());
			noticiaOpcional.get().setFechaPublicacion(noticiaModificada.getFechaPublicacion());
			noticiaOpcional.get().setImagen(noticiaModificada.getImagen());
			return noticiaOpcional.get();
		}
		return null;
	}
	//4e
	@Transactional
	public boolean eliminarNoticia(int idNoticia) {
		Optional<Noticia> noticiaOpcional=noticiaRepository.findById(idNoticia);
		if(noticiaOpcional.isPresent()) {
			noticiaRepository.deleteById(idNoticia);
			return true;
		}
		return false;
	}
}
