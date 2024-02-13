package TestePraticoPoo.poo.dto.empresa;


import TestePraticoPoo.poo.enuns.Cargo;
import TestePraticoPoo.poo.model.EmpresaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaResponseDTO {

    private Cargo cargo;
    private double salario;
    private boolean beneficio;

    public static EmpresaResponseDTO convertToDTO(EmpresaModel empresa){
        var response = new EmpresaResponseDTO();
        response.setBeneficio(empresa.isBeneficio());
        response.setCargo(empresa.getCargo());
        response.setSalario(empresa.getSalario());
        return response;
    }
}
