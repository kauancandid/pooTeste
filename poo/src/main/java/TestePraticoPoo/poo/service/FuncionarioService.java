package TestePraticoPoo.poo.service;


import TestePraticoPoo.poo.dto.funcionario.FuncionarioRequestDTO;
import TestePraticoPoo.poo.model.FuncionarioModel;

public interface FuncionarioService {

    FuncionarioModel add(FuncionarioRequestDTO params);
    void del(String funcionarioId);
}
