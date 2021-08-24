package com.hugo.api.resources;

import com.hugo.api.domains.Post;
import com.hugo.api.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
@CrossOrigin(origins = "*")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<?> findAll(){
        List<Post> posts = service.findAll();

        return ResponseEntity.ok().body(posts);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findOne(@PathVariable Integer id){
        Post post = service.findOne(id);

        return ResponseEntity.ok().body(post);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Post post){
        post = service.insert(post);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Post post, @PathVariable Integer id){
        post.setId(id);
        service.update(post);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}/{action}", method = RequestMethod.POST)
    public ResponseEntity<Void> upDown(@PathVariable Integer id, @PathVariable Integer action){
        Post post = action == 1 ? service.up(id) : service.down(id);

        return ResponseEntity.noContent().build();
    }
}
