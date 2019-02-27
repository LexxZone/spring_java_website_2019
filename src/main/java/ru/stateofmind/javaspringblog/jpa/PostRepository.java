package ru.stateofmind.javaspringblog.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stateofmind.javaspringblog.dto.Post;

/**
 * @author Alexey Dvoryaninov
 * @mail lexxzone@gmail.com
 * created: 2019-02-28
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}
