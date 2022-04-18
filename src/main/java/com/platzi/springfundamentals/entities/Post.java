package com.platzi.springfundamentals.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post", unique = true, nullable = false)
    private Long id;
    private String description;

    @ManyToOne
    private Users user;
}
