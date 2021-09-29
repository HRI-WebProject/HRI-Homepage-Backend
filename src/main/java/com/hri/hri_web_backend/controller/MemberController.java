package com.hri.hri_web_backend.controller;

import java.util.List;

import com.hri.hri_web_backend.global.StatusEnum;
import com.hri.hri_web_backend.global.SuccessResponse;
import com.hri.hri_web_backend.domain.Member;
import com.hri.hri_web_backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @ResponseBody
    @GetMapping("/members")
    public SuccessResponse getMember(){
        List<Member> members = memberService.getMember();
        return SuccessResponse.builder()
            .status(StatusEnum.OK)
            .message("모든 구성원 조회 성공")
            .data(members)
            .build();
    }
}