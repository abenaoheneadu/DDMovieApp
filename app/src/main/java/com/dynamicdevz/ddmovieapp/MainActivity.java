package com.dynamicdevz.ddmovieapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.dynamicdevz.ddmovieapp.databinding.ActivityMainBinding;
import com.dynamicdevz.ddmovieapp.model.data.MovieResponse;
import com.dynamicdevz.ddmovieapp.model.network.MovieRetrofit;
import com.dynamicdevz.ddmovieapp.view.adapter.MovieAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MovieAdapter adapter = new MovieAdapter();
    private MovieRetrofit movieRetrofit= new MovieRetrofit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.movieRecyclerview.setAdapter(adapter);

        Log.d("TAG_X", "Making API Call");
        movieRetrofit.getUpcomingMovies().enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                adapter.setResults(response.body().getMoviesUpcoming());
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
    }
}