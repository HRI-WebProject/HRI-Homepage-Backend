package com.hri.hri_web_backend.service;

import java.util.List;

import com.hri.hri_web_backend.domain.Member;
import com.hri.hri_web_backend.repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> getMembers(){
        return memberRepository.findAll();
    }

    public void registerMember(Member member){
        memberRepository.save(member);
    }
}
