package com.example.marcos;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.marcos.data.ApiService;
import com.example.marcos.model.DolarSi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    Retrofit retrofit;
    Button btnOn;
    ArrayList<String> recordings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOn = findViewById(R.id.btn_on);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.dolarsi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        popo();
    }

    private void popo() {
        ApiService service = retrofit.create(ApiService.class);
        Call<ArrayList<DolarSi>> call = service.getDollars();

        call.enqueue(new Callback<ArrayList<DolarSi>>() {
            @Override
            public void onResponse(Call<ArrayList<DolarSi>> call, Response<ArrayList<DolarSi>> response) {
                assert response.body() != null;

                Log.e("RTA", response.body().toString());
            }

            @Override
            public void onFailure(Call<ArrayList<DolarSi>> call, Throwable t) {
                Log.e("400", t.getMessage());
            }
        });

    }
}