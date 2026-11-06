package br.edu.ifpi.apibiblioteca.service;

import br.edu.ifpi.apibiblioteca.model.Livro;
import br.edu.ifpi.apibiblioteca.repository.LivroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public Livro cadastrar(Livro livro) {
        return repository.save(livro);
    }

    public List<Livro> listar() {
        return repository.findAll();
    }

    public Livro buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Livro não encontrado"));
    }

    public List<Livro> listarDisponiveis() {
        return repository.findByDisponivelTrue();
    }
}
