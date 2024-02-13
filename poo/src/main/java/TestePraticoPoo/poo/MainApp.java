package TestePraticoPoo.poo;

import TestePraticoPoo.poo.dto.empresa.ParametrosRequestDTO;
import TestePraticoPoo.poo.model.FuncionarioModel;
import TestePraticoPoo.poo.service.impl.EmpresaServiceImpl;

import java.time.YearMonth;
import java.util.List;

import static TestePraticoPoo.poo.exemplos.ExemploListaFuncionarios.obterListaFuncionarios;

public class MainApp {



    public static void main(String[] args) {

        EmpresaServiceImpl empresaService = new EmpresaServiceImpl();

        List<FuncionarioModel> funcionarios = obterListaFuncionarios();
        ParametrosRequestDTO paramsRequest = new ParametrosRequestDTO();
        paramsRequest.setFuncionarioModelList(funcionarios);
        paramsRequest.setMesAno(YearMonth.of(2022, 1));

        System.out.println("Valor total pago no mês: " + empresaService.calcularValorTotalPagoNoMes(paramsRequest));
        System.out.println("Funcionário com o maior salário: " + empresaService.encontrarFuncionarioMaiorSalario(paramsRequest).getNome());
        System.out.println("Funcionário com o maior benefício: " + empresaService.encontrarFuncionarioMaiorBeneficio(paramsRequest));


    }
}
