package TestePraticoPoo.poo.service.impl;

import TestePraticoPoo.poo.dto.funcionario.FuncionarioRequestDTO;
import TestePraticoPoo.poo.model.FuncionarioModel;
import TestePraticoPoo.poo.repository.FuncionarioReposirtory;
import TestePraticoPoo.poo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioReposirtory funcionarioReposirtory;

    public FuncionarioModel add(FuncionarioRequestDTO params){
        var funcionario = new FuncionarioModel();
        funcionario.setCargo(params.getCargo());
        funcionario.setNome(params.getNome());
        funcionario.setContratacao(params.getContratacao());

        return funcionarioReposirtory.save(funcionario);
    }

    public void del(String funcionarioId){
        var funcionario = funcionarioReposirtory.findById(UUID.fromString(funcionarioId));
        if (funcionario.isPresent()){
            throw new RuntimeException("Funcionario não encontrado");
        }else {
            funcionarioReposirtory.delete(funcionario.get());
        }
    }
}
