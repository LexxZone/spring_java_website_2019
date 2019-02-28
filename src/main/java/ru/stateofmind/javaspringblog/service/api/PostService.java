package ru.stateofmind.javaspringblog.service.api;

import ru.stateofmind.javaspringblog.dto.PostDto;

import java.util.List;

/**
 * @author Alexey Dvoryaninov
 * @mail lexxzone@gmail.com
 * created: 2019-02-27
 */
public interface PostService {
    List<PostDto> search(String query);
}
