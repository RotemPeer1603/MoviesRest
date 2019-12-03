package com.movies.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movies.ErrorMessage;
import com.movies.Movie;

@RestController
public class BasicController {
	private static Map<Integer, Movie> mapMovies = new HashMap<>();

	@RequestMapping(value = "/movie", method = RequestMethod.GET)

	public List<Movie> getAllMovies() {
		List<Movie> lstMovie = new ArrayList<Movie>(mapMovies.values());
		return lstMovie;
	}

	@RequestMapping(value = "/movie", method = RequestMethod.POST)
	public ErrorMessage updateMovie(@RequestBody Movie movie) {
		if (movie.getId() == 0) {
			int maxId = getMaxId();
			movie.setId(maxId);
		}
		mapMovies.put(movie.getId(), movie);
		ErrorMessage errMessage = new ErrorMessage();
		errMessage.setMessage("Movie was updated");
		return errMessage;
	}

	public int getMaxId() {
		int maxId = 0;
		Iterator<Movie> iterator = mapMovies.values().iterator();
		while (iterator.hasNext()) {
			Movie tempMovie = iterator.next();
			if (tempMovie.getId() > maxId) {
				maxId = tempMovie.getId();
			}
		}
		maxId += 1;
		return maxId;
	}

	@RequestMapping(value = "/movie/{id}", method = RequestMethod.DELETE)
	public ErrorMessage deleteMovie(@PathVariable int id) {
		mapMovies.remove(id);
		ErrorMessage errMessage = new ErrorMessage();
		errMessage.setMessage("Movie was deleted");
		return errMessage;
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
