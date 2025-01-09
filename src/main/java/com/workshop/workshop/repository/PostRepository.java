package com.workshop.workshop.repository;

import com.workshop.workshop.domain.Post;
import com.workshop.workshop.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{'title': {$regex: ?0,  $options:  'i'}}")
    List<Post> searchByTitle(String title);

    List<Post> findByTitleContainingIgnoreCase(String text);


}
