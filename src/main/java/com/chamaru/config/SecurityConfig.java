package com.chamaru.config;

import com.chamaru.service.member.LoginFailureHandler;
import com.chamaru.service.member.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// 스프링 부트 3.0 이상이므로 스프링 시큐리티 6.0이상이 강제된다.
// 따라서 최신 스프링 시큐리티 설정을 도입해야 한다

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin(f -> f
                        .loginPage("/member/login")
                        .usernameParameter("userId")
                        .passwordParameter("userPw")
                        .failureHandler(new LoginFailureHandler()) //로그인 실패 시 LoginFailureHandler실행
                        .successHandler(new LoginSuccessHandler()) //로그인 성공 시 LoginSuessHandler실행
                )
                .logout(f -> f
                        .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                        .logoutSuccessUrl("/") //로그아웃 성공 시 URL
                );

        http.authorizeHttpRequests(f -> f
                .requestMatchers("/mypage/**").authenticated() //로그인한 회원만 접근 가능한 URL
                .requestMatchers("/admin/**").hasAuthority("ADMIN") //관리자만 접근 가능한 페이지
                .anyRequest().permitAll()
        );

        /*http.exceptionHandling(f -> f
                .authenticationEntryPoint((req, res, e) -> {
                            String URI = req.getRequestURI(); //현재 접속한 경로
                            if (URI.indexOf("/admin") != -1) { //관리자 - 401
                                // 401 에러 페이지
                                res.sendError(401, "NOT AUTHORIZED");
                                return;
                            }

                            //회원 전용 페이지 - 로그인 페이지로 이동
                            String url = req.getContextPath() + "/member/login";
                            res.sendRedirect(url);
                        }
                ));*/
        return http.build();
    }




    /* @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.formLogin(form -> form
           // 로그인 관련 설정
                .loginPage("/member/login") // 로그인 페이지의 URL을 설정 (POST)
                .usernameParameter("email") // 로그인 페이지에서 사용자 이름을 입력받는 input 요소의 name을 설정
                .passwordParameter("password") // 로그인 페이지에서 비밀번호를 입력받는 input 요소의 name을 설정
                .defaultSuccessUrl("/member/complete?mode=login") // 로그인 성공 후 이동할 페이지
                .failureUrl("/member/login/error")); // 로그인 실패 시 이동할 URL을 설정

        http.logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout")) // 로그아웃 URL 지정 (GET)
                .logoutSuccessUrl("/")); // 로그아웃 성공 시 이동할 페이지

        // 페이지별 HTTP 요청에 대한 권한 설정
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/admin/**").hasRole("ADMIN") // User.builder().roles()를 사용했으므로 hasRole을 사용해야 Role명이 매치가 될 것임
                .anyRequest().permitAll()); // 다른 모든 페이지는 권한 없어도 됨

        return http.build();
    }*/

    // 암호화용 객체
    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
}
