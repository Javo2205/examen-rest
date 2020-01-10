package com.softtek.academia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.softtek.academia.entity.Movie;
import com.softtek.academia.service.MovieServiceImpl;

@RestController
@RequestMapping("/api/movies")
public class MainRestController {

	@Autowired
	MovieServiceImpl movieService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	private List<Movie> getMovies() {
		return movieService.getAllMovies();
	}

	@GetMapping(value = "/{id}/")
	@ResponseStatus(HttpStatus.OK)
	public Movie getMovieById(@PathVariable("id") Integer id) {
		return movieService.getMovieById(id);
	}

	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public Movie addMovie(@RequestBody Movie requestBody) {
		return movieService.saveMovie(requestBody);
	}

	@PutMapping(value = "/{id}/", consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Movie updateMovie(@PathVariable ("id") Integer id , @RequestBody Movie requestBody){
		return movieService.updateMovie(requestBody);		
	}
	
	@DeleteMapping(value = "/{id}/")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteMovie(@PathVariable("id") Integer id) {
		movieService.deleteMovieById(id);
	}
	
	@PatchMapping(value = "/{id}/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Movie patchMovies (@PathVariable("id") Integer id, @RequestBody Movie requestBody){
		return movieService.patchMovie(id, requestBody);
	}
	

}
