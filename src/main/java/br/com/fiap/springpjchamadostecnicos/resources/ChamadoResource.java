package br.com.fiap.springpjchamadostecnicos.resources;

import br.com.fiap.springpjchamadostecnicos.Entity.Chamado;
import br.com.fiap.springpjchamadostecnicos.repository.ChamadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/chamado")
public class ChamadoResource {
    @Autowired
    private ChamadoRepository repo;

    @GetMapping
    public List<Chamado> findAll(){
        return  repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Chamado findByIId(@PathVariable Long id){
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Chamado save(@RequestBody Chamado chamado){
        return  repo.save(chamado);
    }



}
