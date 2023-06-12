package com.chamaru.service.member;

import com.chamaru.constant.MemberType;
import com.chamaru.controller.member.JoinForm;
import com.chamaru.entity.Member;
import com.chamaru.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void join(JoinForm joinForm) {
        Member member = new ModelMapper().map(joinForm, Member.class);

        member.setUserType(MemberType.USER);

        String hash = passwordEncoder.encode(joinForm.getUserPw());
        member.setUserPw(hash);

        memberRepository.saveAndFlush(member);
    }
}
