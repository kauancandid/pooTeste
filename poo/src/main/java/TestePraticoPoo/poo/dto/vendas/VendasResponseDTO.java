package TestePraticoPoo.poo.dto.vendas;


import TestePraticoPoo.poo.model.VendasModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.YearMonth;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendasResponseDTO {
    private String nome;
    private YearMonth mesAno;
    private double valorVendido;

    public static VendasResponseDTO convertToDTO(VendasModel vendas){
        var response = new VendasResponseDTO();
        response.setNome(vendas.getNome());
        response.setMesAno(vendas.getMesAno());
        response.setValorVendido(vendas.getValorVendido());
        return response;
    }

}
