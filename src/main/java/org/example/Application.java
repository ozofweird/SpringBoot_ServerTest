package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*
    @SpringBootApplication
    - 스프링의 자동 설정, 스프링 빈 읽기와 생성을 모두 자동으로 설정


    SpringApplication.run(Application.class, args);
    - 내장 WAS를 실행 (톰캣 없이 JAR 파일로만 실행 가능)
     */
}
