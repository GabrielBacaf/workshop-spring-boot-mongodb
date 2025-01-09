package com.workshop.workshop.resources;

import com.workshop.workshop.domain.Post;
import com.workshop.workshop.domain.User;
import com.workshop.workshop.dto.UserDTO;
import com.workshop.workshop.services.PostService;
import com.workshop.workshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;



    @RequestMapping (value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
       Post obj = postService.findById(id);
        return ResponseEntity.ok().body(obj);
    }



}
