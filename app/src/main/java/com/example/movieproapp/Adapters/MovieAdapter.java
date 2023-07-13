package com.example.movieproapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieproapp.databinding.MovieListItemsBinding;
import com.example.movieproapp.model.Movie;
import com.example.movieproapp.View.MovieActivity;
import com.example.movieproapp.R;

import java.util.ArrayList;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private Context context;
    private ArrayList<Movie> movieArrayList;

    public MovieAdapter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieListItemsBinding movieListItemBinding = DataBindingUtil.inflate
                (LayoutInflater.from(parent.getContext()),
                        R.layout.movie_list_items,
                        parent,
                        false);

        return new MovieViewHolder(movieListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        Movie movie = movieArrayList.get(position);
        holder.movieListItemBinding.setMovie(movie);

    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }


    // View Holder Class
    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private MovieListItemsBinding movieListItemBinding;

        public MovieViewHolder(MovieListItemsBinding movieListItemBinding) {
            super(movieListItemBinding.getRoot());
            this.movieListItemBinding = movieListItemBinding;

            movieListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION) {
                        Movie selectedMovie = movieArrayList.get(position);


                        Intent i = new Intent(context, MovieActivity.class);

                        i.putExtra("movie", selectedMovie);
                        context.startActivity(i);

                    }


                }
            });

        }
    }
}
