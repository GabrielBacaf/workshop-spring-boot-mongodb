package com.workshop.workshop.config;

import com.workshop.workshop.domain.Post;
import com.workshop.workshop.domain.User;
import com.workshop.workshop.dto.AuthorDTO;
import com.workshop.workshop.dto.CommentDTO;
import com.workshop.workshop.repository.PostRepository;
import com.workshop.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "maria", "maria@gmail.com");
        User alex = new User(null, "alex", "alex@gmail.com");
        User bob = new User(null, "bob", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post = new Post(null,
                sdf.parse("21/03/2018"),
                "Partiu viagem" ,
                "Vou viajar para S\u00E3o Paulo", new AuthorDTO( maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"),"Bom dia" , "Acordei feliz hoje!", new AuthorDTO( maria) );

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));

        post.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().add(c3);
        postRepository.save(post);

        postRepository.saveAll(Arrays.asList(post, post2));

        maria.getPosts().addAll(Arrays.asList(post, post2));
        userRepository.save(maria);


    }

}
