package springboot.psp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.psp.entity.Noticia;
@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Integer>{

}
