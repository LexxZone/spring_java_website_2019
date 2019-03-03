package ru.stateofmind.javaspringblog.service.impl;

import org.springframework.stereotype.Service;
import ru.stateofmind.javaspringblog.domain.Post;
import ru.stateofmind.javaspringblog.dto.PostDTO;
import ru.stateofmind.javaspringblog.jpa.PostRepository;
import ru.stateofmind.javaspringblog.service.api.PostService;
import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexey Dvoryaninov
 * @mail lexxzone@gmail.com
 * created: 2019-02-28
 */

@Service
public class DBPostService implements PostService {

    private final PostRepository postRepository;

    public DBPostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostDTO> search(String query) {
        List<Post> posts = query != null && !query.isEmpty() ?
                postRepository.findAllByTitleLike("%" + query + "%")
                :
                postRepository.findAll();
        return posts.stream().map(post -> PostDTO.builder()
                .title(post.getTitle())
                .body(post.getBody())
                .img(post.getImg())
                .build())
                .collect(Collectors.toList());
    }

    // Единожды внесли инфу в БД при запуске
    /*@PostConstruct
    public void setup() {
        postRepository.saveAll(Arrays.asList(
                Post.builder()
                        .title("Первая запись в этом блоге")
                        .body("Текст самого первого поста в этом блоге. Текст кстати, совсем ни про что. Просто для теста. И все! Точка!")
                        .img("/img/001.jpg")
                        .build(),
                Post.builder()
                        .title("Другая не менее интересная запись")
                        .body("Текст самого второго поста в этом блоге. Текст кстати, совсем ни про что. Просто для теста. И все! Точка!")
                        .img("/img/002.jpg")
                        .build(),
                Post.builder()
                        .title("Третий пост про самое главное")
                        .body("Текст самого третьего поста в этом блоге. Текст кстати, совсем ни про что. Просто для теста. И все! Точка!")
                        .img("/img/003.jpg")
                        .build())
        );
    }*/
}
