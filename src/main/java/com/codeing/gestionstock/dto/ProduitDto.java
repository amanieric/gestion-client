package com.codeing.gestionstock.dto;

import com.codeing.gestionstock.entity.Produit;
import com.codeing.gestionstock.exception.EntityNotValidException;
import com.codeing.gestionstock.exception.ErrorCodes;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Builder
@Getter
@Setter
@Slf4j
public class ProduitDto {

    private Integer id;
    private String ref;
    private Double quantity;
    private Double prixUnitaire;

    public static ProduitDto fromEntity(Produit produit){
        if(produit==null){
            log.error("Le produit est null");
            throw new EntityNotValidException("Error, les données sont invalides", ErrorCodes.PRODUIT_NOT_VALID);
        }
        return ProduitDto.builder()
                .id(produit.getId())
                .ref(produit.getRef())
                .quantity(produit.getQuantity())
                .prixUnitaire(produit.getPrixUnitaire())
                .build();
    }

    public static Produit toEntity(ProduitDto produitDto){
        if(produitDto==null){
            log.error("Le produitDto est null");
            throw new EntityNotValidException("Error, les données sont invalides");
        }
        Produit produit = new Produit();
        produit.setId(produitDto.getId());
        produit.setRef(produitDto.getRef());
        produit.setQuantity(produitDto.getQuantity());
        produit.setPrixUnitaire(produitDto.getPrixUnitaire());
        return produit;
    }
}
