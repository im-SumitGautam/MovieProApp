package com.example.movieproapp.Services;

import com.example.movieproapp.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieDataServices {

    //BaseURl
    //https://api.themoviedb.org/3

    //End Point URl
    //movie/popular/157336?api_key=28c30bb5d9ea8862963e923ef74fae64

    //API Key
    //28c30bb5d9ea8862963e923ef74fae64

    @GET("movie/popular")
    Call<Result> getPopularMovie(@Query("api_key") String api_key);
}
