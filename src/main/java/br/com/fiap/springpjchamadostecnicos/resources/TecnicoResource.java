package br.com.fiap.springpjchamadostecnicos.resources;

import br.com.fiap.springpjchamadostecnicos.Entity.Especialidade;
import br.com.fiap.springpjchamadostecnicos.Entity.Solicitante;
import br.com.fiap.springpjchamadostecnicos.Entity.Tecnico;
import br.com.fiap.springpjchamadostecnicos.repository.EspecialidadeRepository;
import br.com.fiap.springpjchamadostecnicos.repository.TecnicoRepository;
import br.com.fiap.springpjchamadostecnicos.repository.TelefoneRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping(value = "/tecnico")
public class TecnicoResource {
    @Autowired
    private TecnicoRepository repo;

    @Autowired
    private EspecialidadeRepository especialidadeRepository;

    @GetMapping
    public List<Tecnico> findAll(){
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Tecnico findById(@PathVariable Long id){
        return repo.findById(id).orElseThrow();
    }

    @PostMapping
    public Tecnico save(@RequestBody Tecnico tecnico) {
        return repo.save(tecnico);
    }

    @Transactional
    @PostMapping(value = "/{id}/especialidade")
    public Tecnico addEspecialidade(@PathVariable Long id, @RequestBody Especialidade a){
        Tecnico tecnico = repo.findById(id).orElseThrow();
        if (Objects.isNull(a)) return null;

        if (Objects.nonNull(a.getId())){
            Especialidade especialidade = especialidadeRepository.findById(a.getId()).orElseThrow();
            tecnico.getEspecialidades().add(especialidade);
            return tecnico;
        }

        tecnico.getEspecialidades().add(a);
        return tecnico;
    }

    @GetMapping(value = "/{id}/especialidade")
    public Set<Especialidade> findEspecialidade(@PathVariable Long id){
        Tecnico tecnico = repo.findById(id).orElseThrow();

        return tecnico.getEspecialidades();
    }



}
