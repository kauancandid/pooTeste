package TestePraticoPoo.poo.controller;


import TestePraticoPoo.poo.dto.funcionario.FuncionarioRequestDTO;
import TestePraticoPoo.poo.dto.funcionario.FuncionarioResponseDTO;
import TestePraticoPoo.poo.service.impl.FuncionarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiTestePoo/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioServiceImpl funcionarioService;

    @PostMapping("/add")
    public ResponseEntity<?> addFuncionario(@RequestBody FuncionarioRequestDTO params) {
        var model = funcionarioService.add(params);
        return ResponseEntity.status(HttpStatus.CREATED).body(FuncionarioResponseDTO.convertToDTO(model));
    }

    @DeleteMapping("/del/{funcionarioId}")
    public ResponseEntity<?> delFuncionario(@PathVariable("funcionarioId") String id) {
        funcionarioService.del(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
