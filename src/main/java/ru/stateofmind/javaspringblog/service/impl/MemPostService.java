package ru.stateofmind.javaspringblog.service.impl;

import org.springframework.stereotype.Service;
import ru.stateofmind.javaspringblog.dto.PostDto;
import ru.stateofmind.javaspringblog.service.api.PostService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alexey Dvoryaninov
 * @mail lexxzone@gmail.com
 * created: 2019-02-27
 */

@Service
public class MemPostService implements PostService {

    private List<PostDto> posts = new ArrayList<>(Arrays.asList(
            PostDto.builder()
                    .title("First Title")
                    .body("First body")
                    .img("/img/001.jpg")
                    .build(),
            PostDto.builder()
                    .title("Second Title")
                    .body("Second body")
                    .img("/img/002.jpg")
                    .build(),
            PostDto.builder()
                    .title("Third Title")
                    .body("Third body")
                    .img("/img/003.jpg")
                    .build())
    );

    @Override
    public List<PostDto> search(String query) {
        return query != null && !query.isEmpty() ?
                posts.stream().filter(post -> post.getTitle().toLowerCase()
                .matches(".*" + query.toLowerCase() + ".*"))
                .collect(Collectors.toList())
                :
                posts;
    }
}
