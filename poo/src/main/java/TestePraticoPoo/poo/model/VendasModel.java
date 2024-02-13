package TestePraticoPoo.poo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.UUID;


@Data
@Entity
@Table(name = "Vendas")
public class VendasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private YearMonth mesAno;

    @Column(nullable = false)
    private double valorVendido;

}