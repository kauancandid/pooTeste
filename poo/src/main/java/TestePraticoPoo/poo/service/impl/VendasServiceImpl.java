package TestePraticoPoo.poo.service.impl;



import TestePraticoPoo.poo.dto.vendas.VendasRequestDTO;
import TestePraticoPoo.poo.model.VendasModel;
import TestePraticoPoo.poo.repository.VendasReposirtory;
import TestePraticoPoo.poo.service.VendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VendasServiceImpl implements VendasService {

    @Autowired
    private VendasReposirtory vendasReposirtory;

//    @Autowired
//    public VendasModel add(VendasRequestDTO params){
//        var vendas = new VendasModel();
//        vendas.setNome(params.getNome());
//        vendas.setMesAno(params.getMesAno());
//        vendas.setValorVendido(params.getValorVendido());
//
//        return vendasReposirtory.save(vendas);
//    }

//    @Autowired
//    public void del(String vendasId){
//        var vendas = vendasReposirtory.findById(UUID.fromString(vendasId));
//        if (vendas.isPresent()){
//            throw new RuntimeException("Vendas não encontrada");
//        }else {
//            vendasReposirtory.delete(vendas.get());
//        }
//    }

    @Autowired
    public List<VendasModel> listarTodasAsVendas(){
        return vendasReposirtory.findAll();
    }
}
