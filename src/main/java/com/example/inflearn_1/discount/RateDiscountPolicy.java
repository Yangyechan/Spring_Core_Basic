package com.example.inflearn_1.discount;

import com.example.inflearn_1.annotation.MainDiscountPolicy;
import com.example.inflearn_1.member.Grade;
import com.example.inflearn_1.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }else {
            return 0;
        }
    }
}
