package com.codeing.gestionstock.service;

import com.codeing.gestionstock.dto.ProduitDto;
import com.codeing.gestionstock.entity.Produit;
import com.codeing.gestionstock.exception.EntityNotFoundException;
import com.codeing.gestionstock.exception.EntityNotValidException;
import com.codeing.gestionstock.exception.ErrorCodes;
import com.codeing.gestionstock.repository.ProduitRepository;
import com.codeing.gestionstock.service.interfaces.ProduitServiceInterfaces;
import com.codeing.gestionstock.validator.ProduitValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProduitService implements ProduitServiceInterfaces {

    private  final ProduitRepository produitRepository;
    @Override
    public ProduitDto createProduit(ProduitDto produitDto) {
        List<String> error = new ArrayList<>();
        error = ProduitValidator.validate(produitDto);
        if(!error.isEmpty() || produitDto==null){
            log.error("Error, produitDto est null");
            throw new EntityNotValidException("Error, les données sont invalides", ErrorCodes.PRODUIT_NOT_VALID);
        }
        return ProduitDto.fromEntity(produitRepository.save(ProduitDto.toEntity(produitDto)));
    }

    @Override
    public ProduitDto findOneProduit(Integer id) {
        if(id==null){
            log.error("L'ID est null");
            throw new EntityNotValidException("Error, les données sont invalides");
        }
        Optional<Produit> produit = produitRepository.findById(id);
        return Optional.of(ProduitDto.fromEntity(produit.get())).orElseThrow(
                ()->new EntityNotFoundException("Error, produit introuvable ",ErrorCodes.PRODUIT_NOT_FOUND)
        );
    }

    @Override
    public List<ProduitDto> getAllProduits() {
        return produitRepository.findAll().stream().map(ProduitDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public Object deleteProduit(Integer id) {
        if(id==null){
            log.error("L'ID est null");
            throw new EntityNotValidException("Error, les données sont invalides",ErrorCodes.PRODUIT_NOT_VALID);
        }
        produitRepository.deleteById(id);
        return null;
    }
}
