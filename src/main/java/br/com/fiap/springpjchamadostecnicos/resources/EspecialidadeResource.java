package br.com.fiap.springpjchamadostecnicos.resources;

import br.com.fiap.springpjchamadostecnicos.Entity.Especialidade;
import br.com.fiap.springpjchamadostecnicos.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/especialidades")
public class EspecialidadeResource {
    @Autowired
    private EspecialidadeRepository repo;

    @GetMapping
    public List<Especialidade> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Especialidade findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @PostMapping
    public Especialidade save(@RequestBody Especialidade especialidade) {
        return repo.save(especialidade);
    }

}
