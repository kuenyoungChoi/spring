package cky.service;

import cky.domain.Prod;
import cky.repository.ProdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class ProdService {

    private final ProdRepository prodRepository;

    public ProdService(ProdRepository prodRepository) {
        this.prodRepository = prodRepository;
    }

    /*상품등록*/
    public Long createProd(Prod prod) {
        validateDuplicateProd(prod); //중복 상품 검증

        prodRepository.save(prod);
        return prod.getId();
    }

    private void validateDuplicateProd(Prod prod) {
        prodRepository.findByName(prod.getName())
                .ifPresent(p -> {
                    throw new IllegalStateException("이미 존재하는 상품 입니다.");
                });
    }

    /*전체 상품 조회*/
    public List<Prod> findProds() {
        return prodRepository.findAll();
    }

    public Optional<Prod> findOne(Long prodId) {
        return prodRepository.findById(prodId);
    }
}
