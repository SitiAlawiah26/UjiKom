package com.example.ujikom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    SemuaProvinsi xxx;
    List<Provinsi> DataProvinsi;
    ApiInterface apiInterface;
    RecyclerView rvProvinsi;
    RecyclerView.LayoutManager layoutnya;
    ProvinsiAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvProvinsi=(RecyclerView)findViewById(R.id.txt_home);
        layoutnya=new LinearLayoutManager(this);
        rvProvinsi.setLayoutManager(layoutnya);
        apiInterface=ApiClient.ambilData().create(ApiInterface.class);
        Call<SemuaProvinsi> call=apiInterface.getprovinsi();
        call.enqueue(new Callback<SemuaProvinsi>() {
            @Override
            public void onResponse(Call<SemuaProvinsi> call, Response<SemuaProvinsi> response) {
                xxx=response.body();
                DataProvinsi=xxx.getProvinsi();
                adapter=new ProvinsiAdapter(DataProvinsi,MainActivity.this);
                rvProvinsi.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<SemuaProvinsi> call, Throwable t) {

            }
        });

    }
}