package com.hugo.api.repositories;

import com.hugo.api.domains.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
}
