package org.example.web;

import org.example.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class,
    excludeFilters =  {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
    })
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @WithMockUser(roles = "USER")
    public void returns_hello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    @WithMockUser(roles = "USER")
    public void returns_helloDto() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount))
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }

    /*
    의존성
    - compile('org.springframework.boot:spring-boot-starter-web')
    - testCompile('org.springframework.boot:spring-boot-starter-test')
    - 이 외의 다른 의존성이 있을 경우 오류가 생길 수 있다.


    @RunWith(SpringRunner.class)
    - JUnit에 내장된 실행자 외에 SpringRunner 실행자를 사용한다.


    @WebMvcTest(controllers = HelloControllers.class)
    - 웹에 기반한 테스트 어노테이션이다.
    - @Service, @Component, @Repository 등을 제외한 @Controller, @ControllerAdvice 등을 사용할 수 있다.
    - SecurityConfig 클래스는 읽지만, SecurityConfig 클래스를 생성하기 위한 @Service인 CustomOAuth2UserService 클래스는 읽지 못하기에 SecurityConfig를 제거해주고 사용자 인증을 추가해주어야 한다.


    private MockMvc mvc;
    - 웹 API 테스트할 때 사용된다.


    mvc.perform(get("/hello")).andExpect(status.isOk()).andExpect(hello);
    - MockMvc를 통해 "/hello" 주소로 GET 요청을 통해 HTTP Header의 Status 검증 및 반환된 문자열 검증을 한다.
     */
}
