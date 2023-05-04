package cky.repository;

import cky.domain.Prod;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
class MemoryProdRepositoryTest {

    MemoryProdRepository repository = new MemoryProdRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    void save() {
        Prod prod = new Prod();
        prod.setName("spring");
        repository.save(prod);

        Prod result = repository.findById(prod.getId()).get();

        assertThat(result).isEqualTo(prod);
    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
        Prod prod1 = new Prod();
        prod1.setName("iva");
        repository.save(prod1);

        Prod prod2 = new Prod();
        prod2.setName("dddp");
        repository.save(prod2);

        Prod result = repository.findByName("iva").get();

        assertThat(result).isEqualTo(prod1);
    }

    @Test
    void findAll() {
        Prod prod1 = new Prod();
        prod1.setName("iva");
        repository.save(prod1);

        Prod prod2 = new Prod();
        prod2.setName("dddp");
        repository.save(prod2);

        List<Prod> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}