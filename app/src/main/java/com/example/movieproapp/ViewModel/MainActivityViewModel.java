package com.example.movieproapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.movieproapp.Model.Result;
import com.example.movieproapp.Repository.MovieRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private MovieRepository movieRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        movieRepository = new MovieRepository(application);

    }
    public MutableLiveData<List<Result>> getAllMovie(){
        return movieRepository.getMovieMutableLiveData();
    }
}
