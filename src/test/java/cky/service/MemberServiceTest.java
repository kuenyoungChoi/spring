package cky.service;

import cky.domain.Member;
import cky.repository.MemberRepository;
import cky.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }
    @Test
    public void join() throws Exception {

        Member member = new Member();
        member.setName("simson");

        Long saveId = memberService.join(member);

        Member findMember = memberRepository.findById(saveId).get();

        assertThat(findMember.getName()).isEqualTo(member.getName());
    }

    @Test
    public void findMembers() throws Exception {

        Member member1 = new Member();
        member1.setName("simson");

        Member member2 = new Member();
        member2.setName("simson");

        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("중복된 회원 입니다.");
    }

    @Test
    void findOne() {
    }
}