package com.hugo.api;

import com.hugo.api.domains.Post;
import com.hugo.api.repositories.PostRepository;
import com.hugo.api.services.PostService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class PostServiceTest {

    @TestConfiguration
    static class PostServiceConfiguration{

        @Bean
        public PostService postService(){
            return new PostService();
        }
    }

    @Autowired
    PostService postService;

    @MockBean
    PostRepository postRepository;

    @Test
    public void inserePost(){
        Optional<Post> post = postRepository.findById(1);
        Post p = post.orElse(null);
        Assertions.assertEquals(p.getTitulo(),"Teste");
    }

    @Before
    public void setup(){
        String titulo = "Teste";
        String conteudo = "Teste Conteudo";
        Date data = new Date();

        Post post = new Post(1, titulo, conteudo, data);

        Mockito.when(postRepository.findById(1))
                .thenReturn(Optional.of(post));

    }


}
