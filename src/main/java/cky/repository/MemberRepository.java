package cky.repository;

import cky.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    Optional<Member> findByTel(Integer tel);

    List<Member> findAll();
    Optional<Member> findOne(Long id);
}
