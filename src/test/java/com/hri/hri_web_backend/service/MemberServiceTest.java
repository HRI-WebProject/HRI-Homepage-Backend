package com.hri.hri_web_backend.service;

import com.hri.hri_web_backend.domain.Member;
import com.hri.hri_web_backend.fixture.MemberFixture.Member1;
import com.hri.hri_web_backend.repository.MemberRepository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.times;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @InjectMocks
    MemberService memberService;

    @Mock
    MemberRepository memberRepository;

    @DisplayName("모든 구성원을 가져온다")
    @Test
    public void getMember() throws Exception {
        //when
        List<Member> members = memberService.getMember();
        //then
        then(memberRepository).should(times(1)).findAll();
    }

    @DisplayName("구성원을 등록한다")
    @Test
    public void registerMember() throws Exception {
        //given
        final Member member = Member1.MEMBER;
        //when
        memberService.registerMember(member);
        //then
        then(memberRepository).should(times(1)).save(member);
    }
}