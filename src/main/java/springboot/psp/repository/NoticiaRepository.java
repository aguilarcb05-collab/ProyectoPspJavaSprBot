package springboot.psp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.psp.entity.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Integer>{

}
