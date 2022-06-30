package com.platzi.springfundamentals.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Data
@RestController
@RequestMapping("/api/v1")
public class UsersController {

    @RequestMapping
    @ResponseBody
    public ResponseEntity<String> function(){
        return new ResponseEntity<>("Hello from controller with changes in path", HttpStatus.ACCEPTED);
    }

    @GetMapping("/")
    public ResponseEntity<String> getMessage(){
        return function();
    }




}
