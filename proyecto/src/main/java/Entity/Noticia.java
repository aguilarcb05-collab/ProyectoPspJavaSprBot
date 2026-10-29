package Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @NotBlank
    private String titulo;

    @NotBlank
    private String contenido;

    @NotNull
    private LocalDate fechaPublicacion;

   
    private String imagen;

   
    @ManyToOne(optional = false) 
    private Administrador administrador;
}