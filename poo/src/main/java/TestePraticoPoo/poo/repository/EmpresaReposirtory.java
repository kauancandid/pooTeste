package TestePraticoPoo.poo.repository;



import TestePraticoPoo.poo.model.EmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmpresaReposirtory extends JpaRepository<EmpresaModel, UUID> {
}
