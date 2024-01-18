package com.codeing.gestionstock.controller;

import com.codeing.gestionstock.controller.interfaces.ProduitControllerInterfaces;
import com.codeing.gestionstock.dto.ProduitDto;
import com.codeing.gestionstock.service.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProduitController implements ProduitControllerInterfaces {

    private final ProduitService produitService;
    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
    private String msg ="Error, Echec de la request ";

    @Override
    public ResponseEntity<Result> create(ProduitDto produitDto) {

        if(produitDto != null){
             this.httpStatus = HttpStatus.OK;
             this.msg = "Ajout d'un nouveau produit";
        }
        Result result = Result.builder()
                .HttpCode(this.httpStatus.value())
                .message(this.msg)
                .response(produitService.createProduit(produitDto))
                .build();
        return new ResponseEntity<>(result,this.httpStatus);
    }

    @Override
    public ResponseEntity<Result> update(ProduitDto produitDto) {
        if(produitDto !=null){
            this.httpStatus=HttpStatus.OK;
            this.msg = "Modification d'un produit ";
        }
        Result result = Result.builder()
                .HttpCode(this.httpStatus.value())
                .message(this.msg)
                .response(produitService.createProduit(produitDto))
                .build();
        return new ResponseEntity<>(result,this.httpStatus);
    }

    @Override
    public ResponseEntity<Result> getAll() {
        this.msg = "Liste de tous les produits";
        this.httpStatus = HttpStatus.OK;
        Result result = Result.builder()
                .message(this.msg)
                .response(produitService.getAllProduits())
                .HttpCode(this.httpStatus.value())
                .build();
        return new ResponseEntity<>(result,this.httpStatus);
    }

    @Override
    public ResponseEntity<Result> findOne(Integer id) {
        this.httpStatus =HttpStatus.OK;
        this.msg = "Un seul produit retourné ";
        Result result = Result.builder()
                .HttpCode(this.httpStatus.value())
                .message(this.msg)
                .response(produitService.findOneProduit(id))
                .build();
        return new ResponseEntity<>(result,this.httpStatus);
    }

    @Override
    public ResponseEntity<Result> delete(Integer id) {
        this.httpStatus = HttpStatus.OK;
        this.msg = "Suppression du produit";
        Result result = Result.builder()
                .HttpCode(this.httpStatus.value())
                .message(this.msg)
                .response(produitService.deleteProduit(id))
                .build();
        return null;
    }
}
