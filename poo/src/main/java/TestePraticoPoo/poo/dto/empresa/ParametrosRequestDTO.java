package TestePraticoPoo.poo.dto.empresa;

import TestePraticoPoo.poo.model.FuncionarioModel;
import lombok.Data;

import java.time.YearMonth;
import java.util.List;

@Data
public class ParametrosRequestDTO {
    private List<FuncionarioModel> funcionarioModelList;
    private YearMonth mesAno;
}
