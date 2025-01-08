package com.workshop.workshop.resources;

import com.workshop.workshop.domain.User;
import com.workshop.workshop.dto.UserDTO;
import com.workshop.workshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = userService.findAll();
        List<UserDTO> listDto = new ArrayList<>();
        for (User x : list) {
            UserDTO userDTO = new UserDTO(x);
            listDto.add(userDTO);
        }
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping (value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
       User obj = userService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

}
