package org.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaConfig {
    /*
    @EnableJpaAuditing
    - @SpringBootApplication 어노테이션과 함께 존재한다.
    - JPA Auditing을 활성화한다.
    - 최소 하나의 @Entity 클래스가 필요하며, @WebMvcTest에는 존재하지 않는다.
     */
}
