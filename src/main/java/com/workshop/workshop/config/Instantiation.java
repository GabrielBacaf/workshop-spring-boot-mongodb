package com.workshop.workshop.config;

import com.workshop.workshop.domain.User;
import com.workshop.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        User maria = new User(null, "maria", "maria@gmail.com");
        User alex = new User(null, "alex", "alex@gmail.com");
        User bob = new User(null, "bob", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
