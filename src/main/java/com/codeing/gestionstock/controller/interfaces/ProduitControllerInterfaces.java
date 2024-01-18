package com.codeing.gestionstock.controller.interfaces;

import com.codeing.gestionstock.controller.Result;
import com.codeing.gestionstock.dto.ProduitDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.codeing.gestionstock.constant.Values.*;
public interface ProduitControllerInterfaces {

    @PostMapping(value = url_base + "/produit")
    ResponseEntity<Result> create(@RequestBody ProduitDto produitDto);
    @PatchMapping(value = url_base + "/update")
    ResponseEntity<Result> update(@RequestBody ProduitDto produitDto);
    @GetMapping(value = url_base + "/produits")
    ResponseEntity<Result> getAll();
    @GetMapping(value = url_base + "/produit/{id}")
    ResponseEntity<Result> findOne(@PathVariable("id") Integer id);
    @DeleteMapping(value = url_base + "/produit/{id}")
    ResponseEntity<Result> delete(@PathVariable("id") Integer id);

}
