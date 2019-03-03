package ru.stateofmind.javaspringblog.service.impl;

import org.springframework.stereotype.Service;
import ru.stateofmind.javaspringblog.domain.Post;
import ru.stateofmind.javaspringblog.dto.PostDto;
import ru.stateofmind.javaspringblog.jpa.PostRepository;
import ru.stateofmind.javaspringblog.service.api.PostService;
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
    public List<PostDto> search(String query) {
        List<Post> posts = query != null && !query.isEmpty() ?
                postRepository.findAllByTitleLike("%" + query + "%")
                :
                postRepository.findAll();
        return posts.stream().map(post -> PostDto.builder()
                .title(post.getTitle())
                .body(post.getBody())
                .img(post.getImg())
                .build())
                .collect(Collectors.toList());
    }
}
