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
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @InjectMocks
    MemberService memberService;

    @Mock
    MemberRepository memberRepository;

    @DisplayName("모든 구성원을 가져온다")
    @Test
    public void getMembers() throws Exception {
        //when
        List<Member> members = memberService.getMembers();
        //then
        then(memberRepository).should(times(1)).findAll();
    }

    @DisplayName("구성원 및 졸업생을을 등록한다")
    @Test
    public void registerMember() throws Exception {
        //given
        final Member member = Member1.MEMBER;
        //when
        memberService.registerMember(member);
        //then
        then(memberRepository).should(times(1)).save(member);
    }

    @DisplayName("구성원 및 졸업생을 수정한다")
    @Test
    public void updateMember() throws Exception {
        //given
        final Member member = Member1.MEMBER;

        final Optional<Member> updateMember = Optional.of(Member1.MEMBER);
        given(memberRepository.findById(any())).willReturn(updateMember);

        //when
        memberService.changeMemberInfo(member, Member1.ID);

        //then
        then(memberRepository).should(times(1)).save(any());
    }
}