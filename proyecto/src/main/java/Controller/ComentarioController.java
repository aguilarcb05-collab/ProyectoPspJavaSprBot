package Controller;


import Service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Entity.Comentario;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    // Solo el administrador debe poder ver los comentarios (se protege con Spring Security luego)
    @GetMapping("/actividad/{actividadId}")
    public ResponseEntity<List<Comentario>> getComentariosDeActividad(@PathVariable Long actividadId) {
        return ResponseEntity.ok(comentarioService.getComentariosByActividad(actividadId));
    }

    @PostMapping
    public ResponseEntity<String> saveComentario(@RequestBody Comentario comentario) {
        Comentario comentarioGuardado = comentarioService.saveComentario(comentario);
        if (comentarioGuardado != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Comentario creado");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Actividad no finalizada o no participaste");
        }
    }
}