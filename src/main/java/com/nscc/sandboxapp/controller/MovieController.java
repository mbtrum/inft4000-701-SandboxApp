package com.nscc.sandboxapp.controller;

import com.nscc.sandboxapp.dto.CastMemberDTO;
import com.nscc.sandboxapp.dto.MovieCreateDTO;
import com.nscc.sandboxapp.entity.CastMember;
import com.nscc.sandboxapp.entity.Movie;
import com.nscc.sandboxapp.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    // Constructor
    // Inject the repository into this class
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // GET request - /movies
    @GetMapping("/")
    public List<Movie> GetAllMovies() {
        List<Movie> movies = movieService.getAllMovies();

        // convert movies into DTO
        // return DTO


        return  movies;
    }

    // GET request - /movies/5
    @GetMapping("/{id}")
    public Movie GetMovieById(@PathVariable long id) {
        // Optional<Movie> allows us to throw an exception if not found

        // convert movie into DTO
        // return DTO

        return movieService.getMovieById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // POST request - /movies
    @PostMapping("/")
    public Movie CreateMovie(@Valid @RequestBody MovieCreateDTO movieDTO){
        // Use a DTO to receive the input through API and plug into a movie object.
        Movie movie = new Movie();
        movie.setTitle(movieDTO.getTitle());
        movie.setSynopsis(movieDTO.getSynopsis());

        return movieService.createMovie(movie);
    }

    // POST ../movies/addcastmember
    @PostMapping("/addcastmember")
    public Movie addCastMember(@RequestBody CastMemberDTO castMemberDTO) {
        long movieId = castMemberDTO.getMovieId();

        CastMember castMember = new CastMember();
        castMember.setActorName(castMemberDTO.getActorName());
        castMember.setCharacterName(castMemberDTO.getCharacterName());

        Movie movie = movieService.addCastMemberToMovie(movieId, castMember);

        // Convert Movie into MovieWithCastMembersDTO

        // return DTO

        return movie;
    }
}
