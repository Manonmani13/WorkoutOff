package com.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/moiveprograms")
public class MoviesController {  
	
	private static List<Movies> movies = new ArrayList<Movies>(); 
	
@GetMapping
public List<Movies> getMovies()
{
	return movies;
}

@PostMapping
public Movies addMovies(@RequestBody Movies movie)
{
	movies.add(movie);
	return movie;
}
}
