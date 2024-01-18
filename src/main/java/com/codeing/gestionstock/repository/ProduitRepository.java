package com.codeing.gestionstock.repository;

import com.codeing.gestionstock.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Integer> {
}
