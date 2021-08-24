package com.hugo.api.services;

import com.hugo.api.domains.Post;
import com.hugo.api.repositories.PostRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findOne(Integer id) throws ObjectNotFoundException {
        Optional<Post> post = repository.findById(id);
        if(post == null)
            throw new ObjectNotFoundException("Post Não Encontrado Id: " + id, Post.class.getName());
        return post.orElse(null);
    }

    public List<Post> findAll(){
        return repository.findAll();
    }

    public Post insert(Post post){
        post.setId(null);

        Date dataAtual = new Date();
        post.setData(dataAtual);
        return repository.save(post);
    }

    public Post update(Post post){
        findOne(post.getId());
        return repository.save(post);
    }

    public Post up(Integer id){
        Post post = findOne(id);
        Integer up = post.getUp() + 1;
        post.setUp(up);
        return repository.save(post);
    }

    public Post down(Integer id){
        Post post = findOne(id);
        Integer down = post.getDown() + 1;
        post.setDown(down);
        return repository.save(post);
    }
}
