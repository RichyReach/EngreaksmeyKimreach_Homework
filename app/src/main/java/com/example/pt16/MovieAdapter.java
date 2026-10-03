package com.example.pt16;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pt16.databinding.ItemMovieBinding;

import java.util.List;
import java.util.Locale;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private final List<MovieModel> movieList;

    public MovieAdapter(List<MovieModel> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMovieBinding binding = ItemMovieBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        MovieModel movie = movieList.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movieList != null ? movieList.size() : 0;
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        private final ItemMovieBinding binding;

        public MovieViewHolder(@NonNull ItemMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(MovieModel movie) {
            binding.ivPoster.setImageResource(movie.getImageResId());

            if (movie.getRating() > 0) {
                binding.llRating.setVisibility(View.VISIBLE);
                binding.tvRating.setText(String.format(Locale.getDefault(), "%.1f", movie.getRating()));
            } else {
                binding.llRating.setVisibility(View.VISIBLE);
                binding.tvRating.setText(String.format(Locale.getDefault(), "%.1f", movie.getRating()));
            }

            binding.tvType.setText(movie.getType());
            if ("Free".equalsIgnoreCase(movie.getType())) {
                binding.tvType.setBackgroundResource(R.drawable.bg_badge_free);
            } else {
                binding.tvType.setBackgroundResource(R.drawable.bg_badge_premium);
            }

            binding.tvTitle.setText(movie.getTitle());
            binding.tvYear.setText(String.valueOf(movie.getYear()));
            binding.tvDuration.setText(String.format(Locale.getDefault(), "%d Minutes", movie.getDuration()));
            binding.tvAgeRating.setText(movie.getAgeRating());
            binding.tvGenreCategory.setText(String.format("%s  |  Movie", movie.getGenre()));
        }
    }
}