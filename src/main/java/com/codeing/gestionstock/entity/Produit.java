package com.codeing.gestionstock.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produit extends AbstractEntity{
    private  String ref;
    private Double quantity;
    private Double prixUnitaire;

}
