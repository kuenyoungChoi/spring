package cky;

import cky.repository.MemberRepository;
import cky.repository.MemoryMemberRepository;
import cky.repository.MemoryProdRepository;
import cky.repository.ProdRepository;
import cky.service.MemberService;
import cky.service.ProdService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class springConfig {

    private final DataSource dataSource;

    public springConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Bean
    public ProdService prodService() {
        return new ProdService(prodRepository());
    }

    @Bean
    public ProdRepository prodRepository() {
        return new MemoryProdRepository();
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMem
    }
}
