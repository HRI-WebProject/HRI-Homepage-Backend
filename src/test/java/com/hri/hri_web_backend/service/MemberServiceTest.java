package com.hri.hri_web_backend.service;

import com.hri.hri_web_backend.domain.Member;
import com.hri.hri_web_backend.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void join() throws Exception {
        //given
        Member member = new Member();
        member.setName("test");
        //when
        Long savedId = memberService.join(member);
        //then
        assertEquals(member,memberService.findOne(savedId));
    }

}