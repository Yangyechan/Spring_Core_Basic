package com.example.inflearn_1;

import com.example.inflearn_1.member.Grade;
import com.example.inflearn_1.member.Member;
import com.example.inflearn_1.member.MemberService;
import com.example.inflearn_1.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "MemberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
