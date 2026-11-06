package br.edu.ifpi.apibiblioteca.controller;

import br.edu.ifpi.apibiblioteca.model.Livro;
import br.edu.ifpi.apibiblioteca.service.LivroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @PostMapping
    public Livro cadastrar(@RequestBody Livro livro) {
        return service.cadastrar(livro);
    }

    @GetMapping
    public List<Livro> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // Funcionalidade adicional sugerida na atividade.
    @GetMapping("/disponiveis")
    public List<Livro> listarDisponiveis() {
        return service.listarDisponiveis();
    }
}
