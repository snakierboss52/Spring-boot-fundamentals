package com.platzi.springfundamentals.repository;

import com.platzi.springfundamentals.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);

    List<Users> findByName(String name);

    List<Users> findAll();
}