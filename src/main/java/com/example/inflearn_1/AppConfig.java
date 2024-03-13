package com.example.inflearn_1;

import com.example.inflearn_1.discount.DiscountPolicy;
import com.example.inflearn_1.discount.FixDiscountPolicy;
import com.example.inflearn_1.discount.RateDiscountPolicy;
import com.example.inflearn_1.member.MemberService;
import com.example.inflearn_1.member.MemberServiceImpl;
import com.example.inflearn_1.member.MemoryMemberRepository;
import com.example.inflearn_1.order.OrderService;
import com.example.inflearn_1.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
