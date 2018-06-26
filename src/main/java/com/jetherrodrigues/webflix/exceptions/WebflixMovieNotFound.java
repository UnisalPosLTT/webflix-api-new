package com.jetherrodrigues.webflix.exceptions;

public class WebflixMovieNotFound extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8613886387063802199L;

	public WebflixMovieNotFound() {
	}

	public WebflixMovieNotFound(String message) {
		super(message);
	}
}
