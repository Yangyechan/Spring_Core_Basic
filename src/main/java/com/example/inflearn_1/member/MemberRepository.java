package com.example.inflearn_1.member;

public interface MemberRepository {
    void save (Member member);

    Member findById(Long memberId);
}
