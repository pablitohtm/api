package com.hugo.api.services;

import com.hugo.api.domains.Post;
import com.hugo.api.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findOne(Integer id){
        Optional<Post> post = repository.findById(id);
        return post.orElse(null);
    }

    public List<Post> findAll(){
        return repository.findAll();
    }
}
