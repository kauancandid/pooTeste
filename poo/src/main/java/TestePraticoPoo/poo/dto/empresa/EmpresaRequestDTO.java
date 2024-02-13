package TestePraticoPoo.poo.dto.empresa;

import TestePraticoPoo.poo.enuns.Cargo;
import lombok.Data;

@Data
public class EmpresaRequestDTO {
    private Cargo cargo;
    private double salario;
    private boolean beneficio;
}
