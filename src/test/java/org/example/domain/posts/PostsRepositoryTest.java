package org.example.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    // 저장, 조회 JPA Repository 테스트
    @Test
    public void posts_saveAndFind() {
        // given
        String title = "title";
        String content = "content";

        postsRepository.save(
                Posts.builder()
                .title(title)
                .content(content)
                .author("author")
                .build()
        );

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    // 생성 날짜, 수정 날짜 JPA Repository 테스트
    @Test
    public void baseTimeEntity_save() {
        // given
        LocalDateTime now = LocalDateTime.of(2020,9,24,0,0,0);
        postsRepository.save(
                Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build()
        );

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        System.out.println(">>>>>>>>>> createDate=" + posts.getCreatedDate() + ", modifiedDate=" + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
