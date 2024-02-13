package TestePraticoPoo.poo.model;


import TestePraticoPoo.poo.enuns.Cargo;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "Empresa")
public class EmpresaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private Cargo cargo;
    @Column(nullable = false)
    private double salario;
    @Column(nullable = false)
    private boolean beneficio;
}
