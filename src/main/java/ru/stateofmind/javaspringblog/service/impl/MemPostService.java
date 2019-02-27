package ru.stateofmind.javaspringblog.service.impl;

import org.springframework.stereotype.Service;
import ru.stateofmind.javaspringblog.dto.Post;
import ru.stateofmind.javaspringblog.service.api.PostService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alexey Dvoryaninov
 * @mail lexxzone@gmail.com
 * created: 2019-02-27
 */

@Service
public class MemPostService implements PostService {

    private List<Post> posts = new ArrayList<>(Arrays.asList(
            Post.builder()
                    .title("First Title")
                    .body("First body")
                    .build(),
            Post.builder()
                    .title("Second Title")
                    .body("Second body")
                    .build(),
            Post.builder()
                    .title("Third Title")
                    .body("Third body")
                    .build())
    );

    @Override
    public List<Post> search() {
        return posts;
    }
}
