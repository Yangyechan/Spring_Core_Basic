package com.example.inflearn_1;

import com.example.inflearn_1.discount.DiscountPolicy;
import com.example.inflearn_1.discount.FixDiscountPolicy;
import com.example.inflearn_1.discount.RateDiscountPolicy;
import com.example.inflearn_1.member.MemberService;
import com.example.inflearn_1.member.MemberServiceImpl;
import com.example.inflearn_1.member.MemoryMemberRepository;
import com.example.inflearn_1.order.OrderService;
import com.example.inflearn_1.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
