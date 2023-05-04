package cky.service;

import cky.domain.Prod;
import cky.repository.MemoryProdRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProdServiceTest {

    ProdService prodService;
    MemoryProdRepository prodRepository;

    @BeforeEach
    public void beforeEach() {
        prodRepository = new MemoryProdRepository();
        prodService = new ProdService(prodRepository);
    }

    @AfterEach
    public void afterEach() {
        prodRepository.clearStore();
    }
    @Test
    void createProd() {
        //given
        Prod prod = new Prod();
        prod.setName("spring");
        //when
        Long saveId = prodService.createProd(prod);
        //then
        Prod findProd = prodService.findOne(saveId).get();

        assertThat(prod.getName()).isEqualTo(findProd.getName());
    }

    @Test
    void findProds() {
    }

    @Test
    public void duplicateProd() {
        //given
        Prod prod1 = new Prod();
        prod1.setName("spring");

        Prod prod2 = new Prod();
        prod2.setName("spring");
        //when
        prodService.createProd(prod1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> prodService.createProd(prod2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 상품 입니다.");

//        try {
//            prodService.createProd(prod2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 상품 입니다.");
//        }
        //then
    }
}