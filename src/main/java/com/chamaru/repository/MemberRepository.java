package com.chamaru.repository;

import com.chamaru.entity.Member;
import com.chamaru.entity.QMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface MemberRepository extends JpaRepository<Member, Long>, QuerydslPredicateExecutor<Member> {
    Member findByUserId(String userId); //아이디로 회원 찾기

    default boolean exists(String userId) { //회원이 존재하는지 체크 (이미 있으면 true)
        QMember member = QMember.member;

        return exists(member.userId.eq(userId));
    }

}
