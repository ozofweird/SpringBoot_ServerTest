package org.example.config.auth;

import lombok.RequiredArgsConstructor;
import org.example.domain.user.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/**").hasRole(Role.USER.name())
                    .anyRequest().authenticated()
                .and()
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService);
    }

    /*
    @EnableWebSecurity
    - 스프링 시큐리티 설정을 활성화한다.


    csrf().disable().headers().frameOptions().disable()
    - h2-console 화면을 사용하기 위해 비활성화 한다.


    authorizeRequests(), antMatchers()
    - URL 별로 권한 관리를 설정한다.
    - authorizeRequest()가 선언이 되어야 antMatchers() 옵션을 사용할 수 있다.
    - antMatchers()는 권한 관리 대상을 지정하는 옵션이다.


    anyRequest().authenticated()
    - 설정된 값들 이외의 URL은 모두 인증된 사용자들만 허용하도록 설정한다.


    logout().logoutSuccessUrl("/")
    - 로그아웃 기능에 대한 설정이다.


    oauth2Login().userInfoEndpoint().userService()
    - OAuth2 로그인 기능에 대한 설정이다.
    - userInfoEndpoint()는 OAuth2 로그인 성공 후 사용자 정보를 가져올 때의 설정이다.
    - userService()는 소셜 로그인 성공 시 후속 조치를 취할 UserService 인터페이스의 구현체를 등록한다.

     */
}
