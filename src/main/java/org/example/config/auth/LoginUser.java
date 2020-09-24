package org.example.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
    /*
    @Target(ElementType.PARAMETER)
    - 해당 어노테이션이 사용될 위치를 지정한다.
    - 메서드의 인자값으로 선언될 수 있다.


    @interface
    - LoginUser 클래스를 어노테이션 클래스로 지정해준다.
     */
}
