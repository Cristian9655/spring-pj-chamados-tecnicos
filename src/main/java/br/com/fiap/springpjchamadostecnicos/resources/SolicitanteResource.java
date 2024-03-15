package br.com.fiap.springpjchamadostecnicos.resources;

import br.com.fiap.springpjchamadostecnicos.Entity.Endereco;
import br.com.fiap.springpjchamadostecnicos.Entity.Solicitante;
import br.com.fiap.springpjchamadostecnicos.Entity.Telefone;
import br.com.fiap.springpjchamadostecnicos.repository.EnderecoRepository;
import br.com.fiap.springpjchamadostecnicos.repository.SolicitanteRepository;
import br.com.fiap.springpjchamadostecnicos.repository.TecnicoRepository;
import br.com.fiap.springpjchamadostecnicos.repository.TelefoneRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/solicitantes")
public class SolicitanteResource {
    @Autowired
    private SolicitanteRepository repo;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @GetMapping
    public List<Solicitante> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Solicitante findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @PostMapping
    public Solicitante save(@RequestBody Solicitante solicitante) {
        return repo.save(solicitante);
    }

    @Transactional
    @PostMapping(value = "/{idSolicitante}/endereco")
    public Endereco persistEndereco(@PathVariable("idSolicitante") Long idSolicitante, @RequestBody Endereco endereco){
        Solicitante solicitante = repo.findById(idSolicitante).orElseThrow();
        endereco.setSolicitante(solicitante);
        return enderecoRepository.save(endereco);
    }

    @GetMapping(value = "/{idSolicitante}/endereco")
    public List<Endereco> getEnderecos(@PathVariable("idSolicitante") Long idSolicitante){
        return enderecoRepository.findBySolicitanteId(idSolicitante);
    }

    @GetMapping(value = "/{idSolicitante}/telefone")
    public List<Telefone> findBySolicitante(@PathVariable("idSolicitante") Long idSolicitante){
        return telefoneRepository.findBySolicitanteId(idSolicitante);
    }

    @Transactional
    @PostMapping(value = "/{idSolicitante}/telefone")
    public Telefone persistTelefone(@PathVariable("idSolicitante") Long idSolicitante, @RequestBody Telefone telefone){
        Solicitante solicitante = repo.findById(idSolicitante).orElseThrow();
        telefone.setSolicitante(solicitante);
        return telefoneRepository.save(telefone);
    }


}