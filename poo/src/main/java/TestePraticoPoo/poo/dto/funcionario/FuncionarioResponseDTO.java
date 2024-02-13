package TestePraticoPoo.poo.dto.funcionario;

import TestePraticoPoo.poo.enuns.Cargo;
import TestePraticoPoo.poo.model.FuncionarioModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioResponseDTO {

    private String nome;
    private Cargo cargo;
    private LocalDate contratacao;

    public static FuncionarioResponseDTO convertToDTO(FuncionarioModel funcionario){
        var response = new FuncionarioResponseDTO();
        response.setNome(funcionario.getNome());
        response.setCargo(funcionario.getCargo());
        response.setContratacao(funcionario.getContratacao());
        return response;
    }
}
