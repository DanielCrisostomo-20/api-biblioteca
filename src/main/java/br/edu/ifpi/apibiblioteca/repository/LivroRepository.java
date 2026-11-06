package br.edu.ifpi.apibiblioteca.repository;

import br.edu.ifpi.apibiblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    // Busca somente os livros cujo campo disponivel seja true.
    List<Livro> findByDisponivelTrue();
}
