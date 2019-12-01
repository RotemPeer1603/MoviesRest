package com.movies.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movies.Movie;

@RestController
public class BasicController
{
	private static Map<String, Movie> mapMovies = new HashMap<String, Movie>();

	static
	{

		Movie movie = new Movie();
		movie.setName("name");
		movie.setImageName("imageName");
		List<String> lstActors = new ArrayList<String>();
		lstActors.add("sharif");
		lstActors.add("dan toren");
		movie.setLstActors(lstActors);
		mapMovies.put(movie.getName(), movie);
	}

	@RequestMapping(value = "/movie", method = RequestMethod.GET)

	public List<Movie> getMovies()
	{
		List<Movie> lstMovie = new ArrayList<Movie>(mapMovies.values());
		return lstMovie;
	}

	@RequestMapping(value = "/movie", method = RequestMethod.POST)
	public Movie addMovie(@RequestBody Movie movie)
	{
		return movie;
	}

	@RequestMapping(value = "/movie", method = RequestMethod.PUT)
	public String updateMovies()
	{
		return "Movie was updated!";
	}

	@RequestMapping(value = "/movie", method = RequestMethod.DELETE)
	public String deleteCoupon()
	{
		return "Movie was deleted!";
	}

//	@RequestMapping("/movie/{id}") 
//	@ResponseBody
//	public List<Integer> sayHello(@PathVariable int id) {
//		return Arrays.asList(id, 7, 8, 9);
//	}
//
//	// @DeleteMapping
//	@PostMapping("/wee")
//	@ResponseBody
//	public List<Integer> add() {
//		return Arrays.asList(7, 8, 9);
//	}
//	

}
