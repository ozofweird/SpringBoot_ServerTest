package org.example.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombok_test() {
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

    /*
    gradle/wrapper/gradle-wrapper.properties
    - Gradle 버전이 5로 상향되면서 Lombok 설정이 변경이 되었기에, distributionUrl의 Gradle 버전이 4여야 동작한다.
    - 프로젝트의 루트 디렉토리 터미널에서 4.10.2 버전으로 수정 명령어("./gradlew wrapper --gradle-version 4.10.2")를 적용한다.


    import static org.assertj.core.api.Assertions.assertThat;
    - JUnit의 assertThat()과 달리, is()와 같은 CoreMatchers 라이브러리가 불필요하며 자동완성이 확실하게 지원된다.
     */
}
