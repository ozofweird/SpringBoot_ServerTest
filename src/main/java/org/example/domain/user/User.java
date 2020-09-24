package org.example.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

    /*
    @Enumerated(EnumType.STRING)
    - JPA로 데이터베이스에 저장할 때, Enum 값을 어떤 형태로 저장할지 결정한다.
    - 기본적으로는 int로 저장이 되지만 숫자로 저장할 경우, 어떤 코드를 의미하는지 알 수 없기에 문자열로 저장한다.
     */
}
