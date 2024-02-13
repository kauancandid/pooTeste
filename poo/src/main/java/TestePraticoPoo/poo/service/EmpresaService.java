package TestePraticoPoo.poo.service;


import TestePraticoPoo.poo.dto.empresa.ParametrosRequestDTO;
import TestePraticoPoo.poo.model.FuncionarioModel;

import java.util.List;

public interface EmpresaService {

    double calcularValorTotalPagoNoMes(ParametrosRequestDTO paramsRequest);
    double calcularSalarioComBeneficioTotalPagoNoMes(ParametrosRequestDTO paramsRequest);
    double calcularTotalBeneficiosNoMes(ParametrosRequestDTO paramsRequest);
    FuncionarioModel encontrarFuncionarioMaiorSalario(ParametrosRequestDTO paramsRequest);
    String encontrarFuncionarioMaiorBeneficio(ParametrosRequestDTO paramsRequest);
    String encontrarVendedorMaisVendeu(List<FuncionarioModel> vendedores, int mes, int ano);
}
