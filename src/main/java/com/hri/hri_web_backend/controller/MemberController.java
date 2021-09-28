package com.hri.hri_web_backend.controller;

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
    @PostMapping(value = "/members/new")
    public String create(@RequestBody Member member){
        memberService.join(member);
        System.out.println("member id = " + member.getId() +" member name = "+ member.getName());
        return "join success";
    }

    @ResponseBody
    @RequestMapping("/index")
    public String home() {
        return "home";
    }
}
