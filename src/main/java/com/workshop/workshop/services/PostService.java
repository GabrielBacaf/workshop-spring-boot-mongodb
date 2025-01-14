package com.workshop.workshop.services;

import com.workshop.workshop.domain.Post;


import com.workshop.workshop.repository.PostRepository;

import com.workshop.workshop.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class PostService {
    @Autowired
    private PostRepository repository;


    public Post findById(String id) {
        if (!repository.existsById(id)) {
            throw new ObjectNotFoundException("Objeto  não encontrado");
        }

        return repository.findById(id).get();
    }

    public List<Post> findByTitle(String text ) {
        return repository.findByTitleContainingIgnoreCase(text);
    }

    public List<Post> findSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.fullSearch(text, minDate, maxDate);


    }


}
