package TestePraticoPoo.poo.service.impl;

import TestePraticoPoo.poo.dto.empresa.EmpresaRequestDTO;
import TestePraticoPoo.poo.dto.empresa.ParametrosRequestDTO;
import TestePraticoPoo.poo.enuns.Cargo;
import TestePraticoPoo.poo.model.EmpresaModel;
import TestePraticoPoo.poo.model.FuncionarioModel;
import TestePraticoPoo.poo.repository.EmpresaReposirtory;
import TestePraticoPoo.poo.repository.VendasReposirtory;
import TestePraticoPoo.poo.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private VendasReposirtory vendasReposirtory;
    @Autowired
    private EmpresaReposirtory empresaReposirtory;


    @Autowired
    public EmpresaModel add(EmpresaRequestDTO params){
        var empresa = new EmpresaModel();
        empresa.setCargo(params.getCargo());
        empresa.setBeneficio(params.isBeneficio());
        empresa.setSalario(params.getSalario());

        return empresaReposirtory.save(empresa);
    }

    @Autowired
    public void del(String empresaId){
        var empresa = empresaReposirtory.findById(UUID.fromString(empresaId));
        if (empresa.isPresent()){
            throw new RuntimeException("Empresa não encontrada");
        }else {
            empresaReposirtory.delete(empresa.get());
        }
    }

    @Autowired
    public double calcularValorTotalPagoNoMes(ParametrosRequestDTO paramsRequest) {
        double totalPago = 0.0;

        for (FuncionarioModel funcionario : paramsRequest.getFuncionarioModelList()) {
            double salarioComBeneficio = calcularSalarioComBeneficio(funcionario, paramsRequest.getMesAno());
            totalPago += salarioComBeneficio;
        }

        return totalPago;
    }

    private double calcularSalarioComBeneficio(FuncionarioModel funcionario, int mes, int ano) {
        double salario = funcionario.getCargo().getSalarioBase();
        double beneficio = funcionario.getCargo().getBeneficioPorAnoDeServico() * calcularAnosDeServico(funcionario, ano);

        if (funcionario.getCargo() == Cargo.VENDEDOR) {
            beneficio += calcularBeneficioPorVendas(funcionario, mes, ano);
        }

        return salario + beneficio;
    }

    private int calcularAnosDeServico(FuncionarioModel funcionario, int ano) {
        return ano - funcionario.getContratacao().getYear();
    }

    private double calcularBeneficioPorVendas(FuncionarioModel vendedor, int mes, int ano) {
        double totalVendas = vendasReposirtory.obterTotalVendasPorVendedorEAnoMes(vendedor.getNome(), ano, mes);
        return totalVendas * vendedor.getCargo().getPercentualBeneficioPorVenda();
    }


    @Autowired
    public double calcularSalarioComBeneficioTotalPagoNoMes(ParametrosRequestDTO paramsRequest) {
        double totalPago = 0.0;

        for (FuncionarioModel funcionario : paramsRequest.getFuncionarioModelList()) {
            double salarioComBeneficio = calcularSalarioComBeneficio(funcionario, paramsRequest.getMesAno());
            totalPago += salarioComBeneficio;
        }

        return totalPago;
    }

    private double calcularSalarioComBeneficio(FuncionarioModel funcionario, YearMonth mesAno) {
        double salario = funcionario.getCargo().getSalarioBase();
        double beneficio = funcionario.getCargo().getBeneficioPorAnoDeServico() * calcularAnosDeServico(funcionario, mesAno);

        if (funcionario.getCargo() == Cargo.VENDEDOR) {
            beneficio += calcularBeneficioPorVendas(funcionario, mesAno);
        }

        return salario + beneficio;
    }

    private int calcularAnosDeServico(FuncionarioModel funcionario, YearMonth mesAno) {
        return mesAno.getYear() - funcionario.getContratacao().getYear();
    }

    private double calcularBeneficioPorVendas(FuncionarioModel vendedor, YearMonth mesAno) {
        double totalVendas = vendasReposirtory.obterTotalVendasPorVendedorEAnoMes(vendedor.getNome(), mesAno.getYear(), mesAno.getMonthValue());
        return totalVendas * vendedor.getCargo().getPercentualBeneficioPorVenda();
    }


    @Autowired
    public double calcularTotalBeneficiosNoMes(ParametrosRequestDTO paramsRequest) {
        double totalBeneficios = 0.0;

        for (FuncionarioModel funcionario : paramsRequest.getFuncionarioModelList()) {
            double beneficio = calcularBeneficio(funcionario, paramsRequest.getMesAno().getMonthValue(), paramsRequest.getMesAno().getYear());
            totalBeneficios += beneficio;
        }

        return totalBeneficios;
    }

    private double calcularBeneficio(FuncionarioModel funcionario, int mes, int ano) {
        double beneficio = funcionario.getCargo().getBeneficioPorAnoDeServico() * calcularAnosDeServico(funcionario, ano);

        if (funcionario.getCargo() == Cargo.VENDEDOR) {
            beneficio += calcularBeneficioPorVendas(funcionario, mes, ano);
        }

        return beneficio;
    }

    @Autowired
    public FuncionarioModel encontrarFuncionarioMaiorSalario(ParametrosRequestDTO paramsRequest) {
        Optional<FuncionarioModel> funcionarioComMaiorSalario = paramsRequest.getFuncionarioModelList().stream()
                .max(Comparator.comparingDouble(funcionario ->
                        calcularSalarioTotalNoMes(funcionario, paramsRequest.getMesAno().getMonthValue(), paramsRequest.getMesAno().getYear())));

        return funcionarioComMaiorSalario.orElse(null);
    }

    private double calcularSalarioTotalNoMes(FuncionarioModel funcionario, int mes, int ano) {
        return calcularSalarioComBeneficio(funcionario, mes, ano);
    }

    @Autowired
    public String encontrarFuncionarioMaiorBeneficio(ParametrosRequestDTO paramsRequest) {
        FuncionarioModel funcionarioComMaiorBeneficio = paramsRequest.getFuncionarioModelList().stream()
                .filter(funcionario -> funcionario.getCargo().getBeneficioPorAnoDeServico() > 0) // Filtrar funcionários que recebem benefícios
                .max(Comparator.comparingDouble(funcionario ->
                        calcularBeneficioTotal(funcionario, paramsRequest.getMesAno().getMonthValue(), paramsRequest.getMesAno().getYear())))
                .orElse(null);

        return funcionarioComMaiorBeneficio != null ? funcionarioComMaiorBeneficio.getNome() : null;
    }

    private double calcularBeneficioTotal(FuncionarioModel funcionario, int mes, int ano) {
        double beneficio = funcionario.getCargo().getBeneficioPorAnoDeServico() * calcularAnosDeServico(funcionario, ano);

        if (funcionario.getCargo() == Cargo.VENDEDOR) {
            beneficio += calcularBeneficioPorVendas(funcionario, mes, ano);
        }

        return beneficio;
    }

    @Autowired
    public String encontrarVendedorMaisVendeu(List<FuncionarioModel> vendedores, int mes, int ano) {
        FuncionarioModel vendedorMaisVendeu = vendedores.stream()
                .max(Comparator.comparingDouble(vendedor ->
                        calcularTotalVendas(vendedor, mes, ano)))
                .orElse(null);

        return vendedorMaisVendeu != null ? vendedorMaisVendeu.getNome() : null;
    }

    private double calcularTotalVendas(FuncionarioModel vendedor, int mes, int ano) {
        return vendasReposirtory.obterTotalVendasPorVendedorEAnoMes(vendedor.getNome(), ano, mes);
    }
}
