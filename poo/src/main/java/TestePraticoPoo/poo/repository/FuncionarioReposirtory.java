package TestePraticoPoo.poo.repository;


import TestePraticoPoo.poo.model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FuncionarioReposirtory extends JpaRepository<FuncionarioModel, UUID> {
}
