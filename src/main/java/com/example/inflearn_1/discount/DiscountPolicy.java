package com.example.inflearn_1.discount;

import com.example.inflearn_1.member.Member;

public interface DiscountPolicy {
    // @retrun 할인 대상 금액
    int discount(Member member, int price);
}
