package org.example.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "사용자");

    private final String key;
    private final String title;

    /*
    ROLE_GUEST, ROLE_USER
    - 스프링 시큐리티에서는 권한 코드에 항상 'ROLE_' 앞에 선언되어야 한다.
     */
}
