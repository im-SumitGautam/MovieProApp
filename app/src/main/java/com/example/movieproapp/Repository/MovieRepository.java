package com.example.movieproapp.Repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.movieproapp.Model.Movie;
import com.example.movieproapp.Model.Result;
import com.example.movieproapp.R;
import com.example.movieproapp.Services.MovieDataServices;
import com.example.movieproapp.Services.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private ArrayList<Movie> movieArrayList = new ArrayList<>();
    private MutableLiveData<List<Movie>> movieMutableLiveData = new MutableLiveData<>();
    private Application application;

    public MovieRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMovieMutableLiveData(){

        MovieDataServices movieDataServices = RetrofitInstance.getService();
        Call<Result> call = movieDataServices.getPopularMovie(application.getApplicationContext().getString(R.string.api_key));

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();
                if(result != null && result.getResults() != null){
                    movieArrayList = (ArrayList<Movie>) result.getResults();
                    movieMutableLiveData.setValue(movieArrayList);
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });

        return movieMutableLiveData;
    }
}
