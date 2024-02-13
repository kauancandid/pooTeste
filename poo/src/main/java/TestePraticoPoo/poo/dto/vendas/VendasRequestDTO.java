package TestePraticoPoo.poo.dto.vendas;

import lombok.Data;

import java.time.YearMonth;

@Data
public class VendasRequestDTO {

    private String nome;
    private YearMonth mesAno;
    private double valorVendido;
}
