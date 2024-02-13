package TestePraticoPoo.poo.exemplos;

import TestePraticoPoo.poo.enuns.Cargo;
import TestePraticoPoo.poo.model.FuncionarioModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExemploListaFuncionarios {
    public static List<FuncionarioModel> obterListaFuncionarios() {
        List<FuncionarioModel> funcionarios = new ArrayList<>();

        FuncionarioModel funcionario1 = new FuncionarioModel();
        funcionario1.setNome("João");
        funcionario1.setCargo(Cargo.VENDEDOR);
        funcionario1.setContratacao(LocalDate.of(2020, 5, 15)); // Exemplo de data de contratação
        funcionarios.add(funcionario1);

        FuncionarioModel funcionario2 = new FuncionarioModel();
        funcionario2.setNome("Maria");
        funcionario2.setCargo(Cargo.GERENTE);
        funcionario2.setContratacao(LocalDate.of(2018, 10, 1)); // Exemplo de data de contratação
        funcionarios.add(funcionario2);

        FuncionarioModel funcionario3 = new FuncionarioModel();
        funcionario3.setNome("Ana");
        funcionario3.setCargo(Cargo.SECRETARIO);
        funcionario3.setContratacao(LocalDate.of(2019, 3, 10)); // Exemplo de data de contratação
        funcionarios.add(funcionario3);

        return funcionarios;
    }

    public static void main(String[] args) {
        List<FuncionarioModel> funcionarios = obterListaFuncionarios();

        // Exibir os funcionários no console
        for (FuncionarioModel funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome() +
                    ", Cargo: " + funcionario.getCargo() +
                    ", Data de Contratação: " + funcionario.getContratacao());
        }
    }
}
