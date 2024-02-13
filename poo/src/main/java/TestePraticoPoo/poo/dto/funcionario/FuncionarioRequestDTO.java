package TestePraticoPoo.poo.dto.funcionario;

import TestePraticoPoo.poo.enuns.Cargo;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FuncionarioRequestDTO {
    private String nome;
    private Cargo cargo;
    private LocalDate contratacao;
}
