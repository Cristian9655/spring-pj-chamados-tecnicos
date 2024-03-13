package br.com.fiap.springpjchamadostecnicos.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "TB_TECNICO")
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SQ_TECNICO")
    @SequenceGenerator(name = "SQ_TECNICO", sequenceName = "SQ_TECNICO", allocationSize = 1)
    @Column(name = "ID_TECNICO")
    private Long id;

    @Column(name = "NM_TECNICO")
    private  String nome;
}
