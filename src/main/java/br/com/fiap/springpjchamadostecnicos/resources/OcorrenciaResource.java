package br.com.fiap.springpjchamadostecnicos.resources;

import br.com.fiap.springpjchamadostecnicos.Entity.Ocorrencia;
import br.com.fiap.springpjchamadostecnicos.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ocorrencias")
public class OcorrenciaResource {
    @Autowired
    private OcorrenciaRepository repo;

    @GetMapping
    public List<Ocorrencia> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Ocorrencia findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @PostMapping
    public Ocorrencia save(@RequestBody Ocorrencia ocorrencia) {
        return repo.save(ocorrencia);
    }
}
