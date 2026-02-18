package com.nscc.sandboxapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data // Lombok will add the getter and setter methods
@Entity // define as a database entity
public class CastMember {
    @Id // assign the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment the id in database
    private Long id;

    @Column(nullable = false) // definition in the database
    private String ActorName;

    @Column(nullable = false) // definition in the database
    private String CharacterName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false) // foreign key column in Db
    private Movie movie;

}
