package com.hri.hri_web_backend.controller;

import java.util.List;

import javax.validation.Valid;

import com.hri.hri_web_backend.domain.MemberDto;
import com.hri.hri_web_backend.global.StatusEnum;
import com.hri.hri_web_backend.global.SuccessResponse;
import com.hri.hri_web_backend.domain.Member;
import com.hri.hri_web_backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @ResponseBody
    @GetMapping("")
    public SuccessResponse getMembers(){
        List<Member> members = memberService.getMembers();
        return SuccessResponse.builder()
            .status(StatusEnum.OK)
            .message("모든 구성원 조회 성공")
            .data(members)
            .build();
    }

    @ResponseBody
    @PostMapping("")
    public SuccessResponse registerMember(@Valid @RequestBody MemberDto memberDto){
        memberService.registerMember(memberDto);
        return SuccessResponse.builder()
            .status(StatusEnum.OK)
            .message("구성원 및 졸업생 등록 성공")
            .build();
    }

    @ResponseBody
    @PutMapping("/{id}")
    public SuccessResponse updateMember(@Valid @RequestBody MemberDto memberDto, @PathVariable long id){
        memberService.changeMemberInfo(memberDto, id);
        return SuccessResponse.builder()
            .status(StatusEnum.OK)
            .message("구성원 및 졸업생 수정 성공")
            .build();
    }

    @ResponseBody
    @DeleteMapping("/{id}/delete")
    public SuccessResponse deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
        return SuccessResponse.builder()
            .status(StatusEnum.OK)
            .message("구성원 및 졸업생 삭제 성공")
            .build();
    }
}
