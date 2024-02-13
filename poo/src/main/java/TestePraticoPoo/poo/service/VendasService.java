package TestePraticoPoo.poo.service;


import TestePraticoPoo.poo.dto.vendas.VendasRequestDTO;
import TestePraticoPoo.poo.model.VendasModel;

import java.util.List;

public interface VendasService {

//    VendasModel add(VendasRequestDTO params);
//    void del(String vendasId);
    List<VendasModel> listarTodasAsVendas();
}
