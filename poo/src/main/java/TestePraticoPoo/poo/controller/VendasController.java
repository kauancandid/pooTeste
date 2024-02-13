package TestePraticoPoo.poo.controller;

import TestePraticoPoo.poo.dto.vendas.VendasRequestDTO;
import TestePraticoPoo.poo.dto.vendas.VendasResponseDTO;
import TestePraticoPoo.poo.service.impl.VendasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiTestePoo/vendas")
public class VendasController {

    @Autowired
    private VendasServiceImpl vendasService;

//    @PostMapping("/add")
//    public ResponseEntity<?> addVendas(@RequestBody VendasRequestDTO params) {
//        var model = vendasService.add(params);
//        return ResponseEntity.status(HttpStatus.CREATED).body(VendasResponseDTO.convertToDTO(model));
//    }

//    @DeleteMapping("/del/{vendasId}")
//    public ResponseEntity<?> delVendas(@PathVariable("vendasId") String id) {
//        vendasService.del(id);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
}
