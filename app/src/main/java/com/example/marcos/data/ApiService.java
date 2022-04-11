package com.example.marcos.data;

import com.example.marcos.model.DolarSi;

import java.util.ArrayList;

import kotlin.coroutines.Continuation;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface ApiService {
    //https://www.dolarsi.com/api/api.php?type=valoresprincipales
    @GET("api.php?type=valoresprincipales")
    Call<ArrayList<DolarSi>> getDollars();
}
