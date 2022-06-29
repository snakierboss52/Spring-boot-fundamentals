package com.platzi.springfundamentals.controller;

import com.platzi.springfundamentals.entities.Users;
import com.platzi.springfundamentals.repository.UserRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@Data
@RestController
@RequestMapping("/api/v1")
public class UsersController {

    private UserRepository userRepository;

    public UsersController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping
    @ResponseBody
    public ResponseEntity<String> function(){
        return new ResponseEntity<>("Hello from controller with changes in path", HttpStatus.ACCEPTED);
    }

    @PostMapping("/user")
    public Users user(@RequestBody Users user){

        log.info("Creating new user");
        return userRepository.save(user);
    }

    @GetMapping("/user/{userId}")
    public Optional<Users> getUser(@PathVariable("userId") Long id){

        log.info("Going out to search the user");
        return userRepository.findById(id);
    }

    //@GetMapping("/user")
    //public Optional<Users> getInformationUserByEmail(@RequestParam(value="email") String email){
       // log.info("Going out to find user by Email");
        //return userRepository.findByEmail(email);
    //}

    @GetMapping("/user")
    public List<Users> getUserByName(@RequestParam(value="name") String name){
        log.info("Going out to find user by Name");
        return userRepository.findByName(name);
    }

    @GetMapping("/users")
    public List<Users> listUsers(){
        log.info("Going out to find and list all users registered");
        return userRepository.findAll();
    }



}
