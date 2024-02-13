package TestePraticoPoo.poo.model;



import TestePraticoPoo.poo.enuns.Cargo;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "Funcionario")
public class FuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Cargo cargo;
    @Column(nullable = false)
    private LocalDate contratacao;

}
