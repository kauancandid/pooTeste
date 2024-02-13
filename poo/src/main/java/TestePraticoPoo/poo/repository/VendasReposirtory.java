package TestePraticoPoo.poo.repository;


import TestePraticoPoo.poo.model.VendasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface VendasReposirtory extends JpaRepository<VendasModel, UUID> {

    @Query("SELECT COALESCE(SUM(v.valorVendido), 0) FROM VendasModel v WHERE v.nome = :nomeVendedor AND FUNCTION('YEAR', v.mesAno) = :ano AND FUNCTION('MONTH', v.mesAno) = :mes")
    double obterTotalVendasPorVendedorEAnoMes(String nomeVendedor, int ano, int mes);
}
