package com.hri.hri_web_backend.fixture;

import com.hri.hri_web_backend.domain.Member;

public class MemberFixture {

	public static class Member1{
		public static final Long ID = 1L;
		public static final String NAME = "member1";
		public static final String ENG_NAME = "member1_eng";
		public static final String EMAIL = "member1@test.com";
		public static final String PHOTO = "./member1/photo/path";
		public static final String DEGREE = "석사";
		public static final String GRADUATE = "a대학교";

		public static final Member MEMBER = Member.builder()
			.id(ID)
			.name(NAME)
			.engName(ENG_NAME)
			.email(EMAIL)
			.photo(PHOTO)
			.degree(DEGREE)
			.graduate(GRADUATE)
			.build();
	}

	public static class Member2{
		public static final Long ID = 2L;
		public static final String NAME = "member2";
		public static final String ENG_NAME = "member2_eng";
		public static final String EMAIL = "member2@test.com";
		public static final String PHOTO = "./member2/photo/path";
		public static final String DEGREE = "박사";
		public static final String GRADUATE = "a대학교";

		public static final Member MEMBER = Member.builder()
			.id(ID)
			.name(NAME)
			.engName(ENG_NAME)
			.email(EMAIL)
			.photo(PHOTO)
			.degree(DEGREE)
			.graduate(GRADUATE)
			.build();
	}
}