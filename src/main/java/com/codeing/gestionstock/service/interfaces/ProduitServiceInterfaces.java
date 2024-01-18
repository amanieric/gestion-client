package com.codeing.gestionstock.service.interfaces;

import com.codeing.gestionstock.dto.ProduitDto;

import java.util.List;

public interface ProduitServiceInterfaces {
    ProduitDto createProduit(ProduitDto produitDto);
    ProduitDto findOneProduit(Integer id);
    List<ProduitDto> getAllProduits();
    Object deleteProduit(Integer id);
}
