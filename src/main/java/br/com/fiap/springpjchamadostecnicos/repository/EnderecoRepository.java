package br.com.fiap.springpjchamadostecnicos.repository;

import br.com.fiap.springpjchamadostecnicos.Entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository  extends JpaRepository<Endereco, Long>{
    List<Endereco> findBySolicitanteId(Long idSolicitante);
}
