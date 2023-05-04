package cky;

import cky.domain.Member;
import cky.repository.MemberRepository;
import cky.repository.MemoryMemberRepository;
import cky.repository.MemoryProdRepository;
import cky.repository.ProdRepository;
import cky.service.MemberService;
import cky.service.ProdService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class springConfig {

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
        return new MemoryMemberRepository();
    }
}
