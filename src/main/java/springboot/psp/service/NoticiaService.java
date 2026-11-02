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
	private NoticiaRepository noticiaRepository;
	
	//REF 1c Acceder a las noticias publicadas
	public List<Noticia> findByAll(){
		return noticiaRepository.findAll();
	}
	//Ver una sola noticia
	public Optional<Noticia> findById(int id) {
		return noticiaRepository.findById(id);
	}
	
	//REF 4e Crear noticia
	public Noticia create(Noticia nueva) {
		return noticiaRepository.save(nueva);
	}
	//REF 4e Modificar noticia
	@Transactional
	public Noticia update(Noticia nueva, int idNoticia) {
		Optional<Noticia> noticiaOpt = findById(idNoticia);
		if(noticiaOpt.isPresent()) {
			Noticia vieja= noticiaOpt.get();
			vieja.setTitulo(nueva.getTitulo());
			vieja.setContenido(nueva.getContenido());
			vieja.setFechaPublicacion(nueva.getFechaPublicacion());
			vieja.setImagen(nueva.getImagen());
			
			return noticiaRepository.save(vieja);
		}
		return null;
	}
	//REF 4e Eliminar noticia
	@Transactional
	public Boolean delete(int idNoticia) {
		if (noticiaRepository.existsById(idNoticia)) {
			noticiaRepository.deleteById(idNoticia);
			return true;
		}
		return false;
	}
}
