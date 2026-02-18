package com.nscc.sandboxapp.repository;

import com.nscc.sandboxapp.entity.Movie;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// JpaRepository<> specify the Entity and data type for the ID
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @EntityGraph(attributePaths = {"castMembers"}) // @EntityGraph says when you get a Movie, also populate its "castMembers" property.
    Optional<Movie> findMovieWithCastMembersById(Long id); // find movie record by "id" = movie_id

}

