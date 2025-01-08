package com.workshop.workshop.services;

import com.workshop.workshop.domain.User;
import com.workshop.workshop.dto.UserDTO;
import com.workshop.workshop.repository.UserRepository;
import com.workshop.workshop.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        if (!repository.existsById(id)) {
            throw new ObjectNotFoundException("Objeto  não encontrado");
        }

        return repository.findById(id).get();
    }

    public User insert(User obj) {
        return repository.save(obj);

    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());

    }
}
