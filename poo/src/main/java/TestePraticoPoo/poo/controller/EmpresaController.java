package TestePraticoPoo.poo.controller;


import TestePraticoPoo.poo.dto.empresa.EmpresaRequestDTO;
import TestePraticoPoo.poo.dto.empresa.EmpresaResponseDTO;
import TestePraticoPoo.poo.service.impl.EmpresaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiTestePoo/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaServiceImpl empresaService;

    @PostMapping("/add")
    public ResponseEntity<?> addEmpresa(@RequestBody EmpresaRequestDTO params) {
        var model = empresaService.add(params);
        return ResponseEntity.status(HttpStatus.CREATED).body(EmpresaResponseDTO.convertToDTO(model));
    }

    @DeleteMapping("/del/{empresaId}")
    public ResponseEntity<?> delEmpresa(@PathVariable("empresaId") String id) {
        empresaService.del(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }




}
