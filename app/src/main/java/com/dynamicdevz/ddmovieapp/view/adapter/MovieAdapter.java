package com.dynamicdevz.ddmovieapp.view.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dynamicdevz.ddmovieapp.databinding.MovieItemLayoutBinding;
import com.dynamicdevz.ddmovieapp.model.data.MovieResponse;
import com.dynamicdevz.ddmovieapp.model.data.MovieResults;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       MovieItemLayoutBinding binding = MovieItemLayoutBinding.inflate(
               LayoutInflater.from(parent.getContext()),
               parent,
               false
       );

        return new MovieViewHolder(binding);
    }



    private List<MovieResults> results = new ArrayList<>();

    public void setResults(List<MovieResults> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {
    MovieResults result = results.get(position);
        Log.d("TAG_X", result.getTitle() + "");
        holder.binding.titleTextview.setText(result.getTitle());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder{
        MovieItemLayoutBinding binding;

        public MovieViewHolder(MovieItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
