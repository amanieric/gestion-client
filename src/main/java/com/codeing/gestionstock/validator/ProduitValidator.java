package com.codeing.gestionstock.validator;

import com.codeing.gestionstock.dto.ProduitDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ProduitValidator {

    public static List<String> validate(ProduitDto produitDto){
        List<String> error = new ArrayList<>();
        if(produitDto==null){
            error.add("La référence du produit est requise");
        }else{
            if(!StringUtils.hasLength(produitDto.getRef())){
                error.add("La référence du produit est requise");
            }
            if(produitDto.getQuantity()<0){
                error.add("La quantité du produit est invalide");
            }
            if(produitDto.getPrixUnitaire()<0){
                error.add("Le prix unitaire du produit est invalide");
            }
        }

        return error;
    }
}
