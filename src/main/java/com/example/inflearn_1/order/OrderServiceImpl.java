package com.example.inflearn_1.order;

import com.example.inflearn_1.discount.DiscountPolicy;
import com.example.inflearn_1.discount.FixDiscountPolicy;
import com.example.inflearn_1.discount.RateDiscountPolicy;
import com.example.inflearn_1.member.Member;
import com.example.inflearn_1.member.MemberRepository;
import com.example.inflearn_1.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // 구현 클래스를 바꾸는 순간 OrderServiceImpl 클래스를 변병하므로 OCP 위반

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 회원 확인
        int discountPrice = discountPolicy.discount(member, itemPrice); // 단일 책임 원칙 (SRP) 준수, 오더는 오더만 할인정책은 따로 실행
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

// OCP 개방-폐쇄원칙 유지 보수 사항이 생긴다면 코드를 쉽게 확장 할 수 있도록 하고 수정할 떄는 닫혀 있어야 하는 원칙
// DIP 의존 역전 원칙 위반 - 추상에만 의존하도록 바꿔야 한다.
