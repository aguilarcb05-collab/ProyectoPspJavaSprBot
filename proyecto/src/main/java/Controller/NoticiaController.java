package Controller;



import Entity.Noticia;
import Service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/noticias")
public class NoticiaController {

    @Autowired
    private NoticiaService noticiaService;

    @GetMapping
    public ResponseEntity<List<Noticia>> getAll() {
        return ResponseEntity.ok(noticiaService.getAllNoticias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Noticia> findOneNoticia(@PathVariable Long id) {
        Optional<Noticia> noticia = noticiaService.getNoticiaById(id);
        if (noticia.isPresent()) {
            return ResponseEntity.ok(noticia.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<String> saveNoticia(@RequestBody Noticia noticia) {
        Noticia noticiaGuardada = noticiaService.saveNoticia(noticia);
        if (noticiaGuardada != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Noticia creada");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateNoticia(@PathVariable Long id, @RequestBody Noticia updatedNoticia) {
        Noticia response = noticiaService.updateNoticia(id, updatedNoticia);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Noticia actualizada");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Noticia no encontrada");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNoticia(@PathVariable Long id) {
        if (noticiaService.getNoticiaById(id).isPresent()) {
            noticiaService.deleteNoticia(id);
            return ResponseEntity.status(HttpStatus.OK).body("Noticia eliminada");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Noticia no encontrada");
        }
    }
}