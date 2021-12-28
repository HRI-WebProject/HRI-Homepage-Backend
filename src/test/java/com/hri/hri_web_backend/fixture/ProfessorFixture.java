package com.hri.hri_web_backend.fixture;

import com.hri.hri_web_backend.domain.Member;
import com.hri.hri_web_backend.domain.Professor;
import com.hri.hri_web_backend.global.DegreeEnum;

public class ProfessorFixture {

    public static class Professor1{
        public static final Long ID = 1L;
        public static final String NAME = "member1";
        public static final String ENG_NAME = "member1_eng";
        public static final String EMAIL = "member1@test.com";
        public static final String PHOTO = "./member1/photo/path";
        public static final String BOLD_DETAIL = "bold_detail";
        public static final String DETAIL = "detail";

        public static final Professor PROFESSOR = Professor.builder()
                .name(NAME)
                .engName(ENG_NAME)
                .email(EMAIL)
                .photo(PHOTO)
                .detail(DETAIL)
                .boldDetail(BOLD_DETAIL)
                .build();
    }
}
