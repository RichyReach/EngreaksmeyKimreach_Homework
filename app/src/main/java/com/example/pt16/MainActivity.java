package com.example.pt16;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.pt16.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.rvMovies.setLayoutManager(new LinearLayoutManager(this));
        MovieAdapter adapter = new MovieAdapter(getMovieList());
        binding.rvMovies.setAdapter(adapter);
    }

    private List<MovieModel> getMovieList() {
        List<MovieModel> movies = new ArrayList<>();
        movies.add(new MovieModel(4.5, "Premium", "Spider-Man No Way..", 2021, 148, "PG-13", "Action", R.drawable.movie_1));
        movies.add(new MovieModel(4.5, "Free", "Riverdale", 2021, 148, "PG-13", "Action", R.drawable.movie_2));
        movies.add(new MovieModel(4.5, "Premium", "Life of PI", 2021, 148, "PG-13", "Action", R.drawable.movie_3));
        movies.add(new MovieModel(4.5, "Premium", "The Jungle Waiting", 2021, 148, "PG-13", "Action", R.drawable.movie_4));
        movies.add(new MovieModel(4.8, "Premium", "Inception", 2010, 148, "NC-15", "Sci-Fi", R.drawable.movie_5));
        movies.add(new MovieModel(4.0, "Free", "The Dark Knight", 2008, 152, "NC-15", "Action", R.drawable.movie_6));
        movies.add(new MovieModel(4.5, "Premium", "Pulp Fiction", 1994, 154, "R-18", "Crime", R.drawable.movie_7));
        movies.add(new MovieModel(4.1, "Free", "Interstellar", 2014, 169, "NC-15", "Sci-Fi", R.drawable.movie_1));
        movies.add(new MovieModel(4.2, "Premium", "Spider-Man: Into the Spider-Verse", 2018, 117, "G", "Animation", R.drawable.movie_2));
        movies.add(new MovieModel(4.8, "Free", "Parasite", 2019, 132, "R-18", "Thriller", R.drawable.movie_3));
        movies.add(new MovieModel(5.0, "Premium", "The Lord of the Rings", 2001, 178, "NC-15", "Fantasy", R.drawable.movie_4));
        movies.add(new MovieModel(3.7, "Free", "Spirited Away", 2001, 125, "G", "Animation", R.drawable.movie_5));
        movies.add(new MovieModel(4.3, "Premium", "The Matrix", 1999, 136, "NC-15", "Sci-Fi", R.drawable.movie_6));
        movies.add(new MovieModel(4.1, "Free", "Whiplash", 2014, 106, "NC-15", "Drama", R.drawable.movie_7));
        movies.add(new MovieModel(3.9, "Premium", "Iron Man", 2008, 126, "NC-15", "Action", R.drawable.movie_1));
        movies.add(new MovieModel(4.6, "Free", "Coco", 2017, 105, "G", "Animation", R.drawable.movie_2));
        movies.add(new MovieModel(4.2, "Premium", "Blade Runner 2049", 2017, 164, "R-18", "Sci-Fi", R.drawable.movie_3));
        movies.add(new MovieModel(3.4, "Free", "Grand Budapest Hotel", 2014, 99, "NC-15", "Comedy", R.drawable.movie_4));
        movies.add(new MovieModel(4.9, "Premium", "The Silence of the Lambs", 1991, 118, "R-18", "Horror", R.drawable.movie_5));
        movies.add(new MovieModel(4.5, "Free", "Get Out", 2017, 104, "R-18", "Horror", R.drawable.movie_6));
        movies.add(new MovieModel(3.8, "Premium", "Knives Out", 2019, 130, "NC-15", "Mystery", R.drawable.movie_7));
        movies.add(new MovieModel(4.4, "Free", "Toy Story", 1995, 81, "G", "Animation", R.drawable.movie_1));
        movies.add(new MovieModel(4.9, "Premium", "Alien", 1979, 117, "R-18", "Sci-Fi", R.drawable.movie_2));
        movies.add(new MovieModel(4.0, "Free", "Avatar", 2009, 162, "NC-15", "Action", R.drawable.movie_3));
        return movies;
    }
}