package com.chamaru.service.member;

import com.chamaru.entity.Member;
import com.chamaru.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberInfoService implements UserDetailsService {

    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = memberRepository.findByUserId(username);

        if (member == null) {
            throw new UsernameNotFoundException(username);
        }

        MemberInfo memberInfo = new ModelMapper().map(member, MemberInfo.class);

        List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(member.getUserType().toString()));

        memberInfo.setAuthorities(authorities);

        return memberInfo;
    }
}
