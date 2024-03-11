package com.example.inflearn_1.order;

import com.example.inflearn_1.discount.DiscountPolicy;
import com.example.inflearn_1.discount.FixDiscountPolicy;
import com.example.inflearn_1.member.Member;
import com.example.inflearn_1.member.MemberRepository;
import com.example.inflearn_1.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 회원 확인
        int discountPrice = discountPolicy.discount(member, itemPrice); // 단일 책임 원칙 (SRP) 준수, 오더는 오더만 할인정책은 따로 실행
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
