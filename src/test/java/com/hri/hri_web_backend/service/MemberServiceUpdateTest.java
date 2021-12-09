package com.hri.hri_web_backend.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hri.hri_web_backend.domain.Member;
import com.hri.hri_web_backend.domain.MemberDto;
import com.hri.hri_web_backend.fixture.MemberFixture;

@SpringBootTest
public class MemberServiceUpdateTest {
	@Autowired
	MemberService memberService;

	@Test
	public void 멤버업데이트() throws Exception {

		//given
		final Member member= MemberFixture.Member1.MEMBER;
		final MemberDto memberDto = MemberDto.builder()
			.name(member.getName())
			.email(member.getEmail())
			.engName(member.getEngName())
			.photo(member.getPhoto())
			.degree(member.getDegree())
			.graduate(member.getGraduate())
			.build();
		memberService.registerMember(memberDto);

		//when
		final MemberDto changedMemberDto = MemberDto.builder()
			.name("ChangedName")
			.email(member.getEmail())
			.engName(member.getEngName())
			.photo(member.getPhoto())
			.degree(member.getDegree())
			.graduate(member.getGraduate())
			.build();

		memberService.changeMemberInfo(changedMemberDto, 1);

	    //then
		String changedName = memberService.getMembers().get(0).getName();
		Assertions.assertThat(changedName).isEqualTo("ChangedName");

	}

}
