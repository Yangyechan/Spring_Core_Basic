package com.example.inflearn_1;

import com.example.inflearn_1.member.Grade;
import com.example.inflearn_1.member.Member;
import com.example.inflearn_1.member.MemberService;
import com.example.inflearn_1.member.MemberServiceImpl;
import com.example.inflearn_1.order.Order;
import com.example.inflearn_1.order.OrderService;
import com.example.inflearn_1.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
//        MemberService memberService = new MemberServiceImpl(null);
//        OrderService orderService = new OrderServiceImpl(null, null);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
