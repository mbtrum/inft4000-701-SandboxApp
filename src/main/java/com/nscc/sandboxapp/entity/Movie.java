package com.nscc.sandboxapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data // Lombok will add the getter and setter methods
@Entity // define as a database entity
public class Movie {
    @Id // assign the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment the id in database
    private Long id;

    @Column(nullable = false) // definition in the database
    private String title;

    @Column(nullable = false, length = 1000) // definition in the database
    private String synopsis;
}
