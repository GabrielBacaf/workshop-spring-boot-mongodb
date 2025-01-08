package com.workshop.workshop.repository;

import com.workshop.workshop.domain.Post;
import com.workshop.workshop.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {


}
