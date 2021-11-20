package com.hri.hri_web_backend.service;

import java.util.List;
import java.util.Optional;

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

    public void changeMemberInfo(Member member, long id){
        Optional<Member> updateMember = memberRepository.findById(id);
        if(updateMember.isEmpty())
            throw new NullPointerException();

        updateMember.ifPresent(selectMember->{
            selectMember.setName(member.getName());
            selectMember.setEngName(member.getEngName());
            selectMember.setEmail(member.getEmail());
            selectMember.setPhoto(member.getPhoto());
            selectMember.setDegree(member.getDegree());
            selectMember.setGraduate(member.getGraduate());
        });
    }
}
