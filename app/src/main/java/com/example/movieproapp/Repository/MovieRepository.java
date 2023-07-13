package com.example.movieproapp.Repository;


import android.app.Application;

import androidx.lifecycle.MutableLiveData;


import com.example.movieproapp.model.Movie;
import com.example.movieproapp.model.Result;
import com.example.movieproapp.R;
import com.example.movieproapp.Services.MovieDataServices;
import com.example.movieproapp.Services.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MovieRepository {
    private ArrayList<Movie> movies = new ArrayList<>();
    private MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public MovieRepository(Application application) {
        this.application = application;
    }


    public MutableLiveData<List<Movie>> getMutableLiveData(){
        MovieDataServices movieDataService = RetrofitInstance.getService();

        Call<Result> call = movieDataService.getPopularMovie(application.getApplicationContext().getString(R.string.api_key));
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();

                if (result != null && result.getResults() != null){
                    movies = (ArrayList<Movie>) result.getResults();
                    mutableLiveData.setValue(movies);
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
            }
        });

        return mutableLiveData;
    }

}
