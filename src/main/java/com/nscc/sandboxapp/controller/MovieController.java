package com.nscc.sandboxapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    // GET request - /movies
    @GetMapping("/")
    public String GetAllMovies() {
        return "get all movies";
    }

    // GET request - /movies/5
    @GetMapping("/{id}")
    public String GetMovieById(@PathVariable int id) {
        return "get movie by id: " + id;
    }

    // POST request - /movies
    @PostMapping("/")
    public String AddNewMovie(){
        // add new movie in database
        return "Add new movie";
    }

}
