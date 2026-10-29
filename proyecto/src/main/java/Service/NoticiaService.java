package Service;



import Repository.NoticiaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Entity.Noticia;

import java.util.List;
import java.util.Optional;

@Service
public class NoticiaService {

    @Autowired
    private NoticiaRepository noticiaRepository;

    public List<Noticia> getAllNoticias() {
        return noticiaRepository.findAll();
    }

    public Optional<Noticia> getNoticiaById(Long id) {
        return noticiaRepository.findById(id);
    }

    @Transactional
    public Noticia saveNoticia(Noticia noticia) {
        return noticiaRepository.save(noticia);
    }

    @Transactional
    public Noticia updateNoticia(Long id, Noticia noticiaActualizada) {
        Optional<Noticia> optionalNoticia = noticiaRepository.findById(id);
        Noticia res = null;

        if (optionalNoticia.isPresent()) {
            Noticia noticia = optionalNoticia.get();
            noticia.setTitulo(noticiaActualizada.getTitulo());
            noticia.setContenido(noticiaActualizada.getContenido());
            noticia.setImagen(noticiaActualizada.getImagen());
            res = noticiaRepository.save(noticia);
        }
        return res;
    }

    @Transactional
    public boolean deleteNoticia(Long id) {
        if (noticiaRepository.existsById(id)) {
            noticiaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}