package com.hri.hri_web_backend.service;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hri.hri_web_backend.domain.Member;
import com.hri.hri_web_backend.dto.MemberByDegreeDto;
import com.hri.hri_web_backend.dto.MemberDto;
import com.hri.hri_web_backend.fixture.MemberFixture;
import com.hri.hri_web_backend.global.DegreeEnum;

@SpringBootTest
public class MemberByDegreeTest {
	@Autowired
	MemberService memberService;

	@Test
	public void 멤버학위별로가져오기() throws Exception {
	    //given
		//given
		final Member member= MemberFixture.Member1.MEMBER;
		final MemberDto memberDto = MemberDto.builder()
			.name(member.getName())
			.email(member.getEmail())
			.engName(member.getEngName())
			.email(member.getEmail())
			.photo(member.getPhoto())
			.degree(member.getDegree())
			.graduate(member.getGraduate())
			.researchArea(member.getResearchArea())
			.build();
		//given
		final Member member2= MemberFixture.Member2.MEMBER;
		final MemberDto memberDto2 = MemberDto.builder()
			.name(member2.getName())
			.email(member2.getEmail())
			.engName(member2.getEngName())
			.email(member2.getEmail())
			.photo(member2.getPhoto())
			.degree(member2.getDegree())
			.graduate(member2.getGraduate())
			.researchArea(member2.getResearchArea())
			.build();
	    //when
		memberService.registerMember(memberDto);
		memberService.registerMember(memberDto2);

		List<MemberByDegreeDto> membersByDegree = memberService.getMembersByDegree(DegreeEnum.MASTER);
		List<MemberByDegreeDto> membersByDegree2 = memberService.getMembersByDegree(DegreeEnum.BACHELOR);

		//then
		Assertions.assertThat(membersByDegree.get(0).getName()).isEqualTo("member1");
		Assertions.assertThat(membersByDegree2.get(0).getName()).isEqualTo("member2");

	}

}
