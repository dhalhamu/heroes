package com.example.heroes.heroesAPI;

import com.example.heroes.model.Heroes;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface HerosAPI {
    //1. Using Object
    @POST("heroes")
    Call<Void> addHero (@Body Heroes heroes);

    //2. Using @Field
    @FormUrlEncoded
    @POST("heroes")
    Call<Void> addHero (@Field("name") String name, @Field("desc") String desc);
}
