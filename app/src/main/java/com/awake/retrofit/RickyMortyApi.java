package com.awake.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RickyMortyApi {
    @GET("character")
    Call<List<Character>> getCharacter();

}
