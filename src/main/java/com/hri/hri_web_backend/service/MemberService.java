package com.hri.hri_web_backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.hri.hri_web_backend.domain.Member;
import com.hri.hri_web_backend.dto.MemberByDegreeDto;
import com.hri.hri_web_backend.dto.MemberDto;
import com.hri.hri_web_backend.global.DegreeEnum;
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

    public void registerMember(MemberDto memberDto){
        Member member = Member.builder()
            .name(memberDto.getName())
            .engName(memberDto.getEngName())
            .email(memberDto.getEmail())
            .photo(memberDto.getPhoto())
            .degree(memberDto.getDegree())
            .graduate(memberDto.getGraduate())
            .researchArea(memberDto.getResearchArea())
            .build();
        memberRepository.save(member);
    }

    public void changeMemberInfo(MemberDto memberDto, long id){
        Optional<Member> updateMember = memberRepository.findById(id);
        if(updateMember.isEmpty())
            throw new NullPointerException();

        updateMember.ifPresent(selectMember->{
            selectMember.setName(memberDto.getName());
            selectMember.setEngName(memberDto.getEngName());
            selectMember.setEmail(memberDto.getEmail());
            selectMember.setPhoto(memberDto.getPhoto());
            selectMember.setDegree(memberDto.getDegree());
            selectMember.setGraduate(memberDto.getGraduate());
            selectMember.setResearchArea(memberDto.getResearchArea());
        });
    }

    public void deleteMember(Long id){
        memberRepository.deleteById(id);
    }

    public List<MemberByDegreeDto> getMembersByDegree(DegreeEnum degree) {
        List<Member> members = memberRepository.findAllByDegree(degree);
        return  members.stream().map(
            member -> new MemberByDegreeDto(member.getName(), member.getEngName(), member.getEmail(), member.getPhoto(), member.getGraduate(), member.getResearchArea())
        ).collect(Collectors.toList());
    }
}
