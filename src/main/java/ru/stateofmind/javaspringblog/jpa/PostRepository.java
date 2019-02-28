package ru.stateofmind.javaspringblog.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stateofmind.javaspringblog.domain.Post;


/**
 * @author Alexey Dvoryaninov
 * @mail lexxzone@gmail.com
 * created: 2019-02-28
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
