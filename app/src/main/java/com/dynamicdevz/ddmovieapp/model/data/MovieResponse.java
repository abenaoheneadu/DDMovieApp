
package com.dynamicdevz.ddmovieapp.model.data;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieResponse {

    @SerializedName("Movies Upcoming")
    @Expose
    private List<MovieResults> movieResults = null;

    public List<MovieResults> getMoviesUpcoming() {
        return movieResults;
    }

    public void setMoviesUpcoming(List<MovieResults> movieResults) {
        this.movieResults = movieResults;
    }

    public MovieResponse withMoviesUpcoming(List<MovieResults> movieResults) {
        this.movieResults = movieResults;
        return this;
    }

}
