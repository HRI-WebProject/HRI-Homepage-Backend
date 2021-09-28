package com.hri.hri_web_backend.repository;

import com.hri.hri_web_backend.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {
    @PersistenceContext
    EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long memberId){
        return em.find(Member.class, memberId);
    }
}
