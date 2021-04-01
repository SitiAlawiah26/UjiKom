package com.example.ujikom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KabupatenActivity extends AppCompatActivity {
    TextView txtNamaKab;
    RecyclerView rvDaftarKab;
    RecyclerView.LayoutManager layoutManager;
    int kodenya;
    ApiInterface apiInterface2;
    Provinsi provinsinya;
    SemuaKabupaten xxx;
    List<Kabupaten> kabupaten;
    KabupatenAdapter kabupatenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kabupaten);
        txtNamaKab=(TextView)findViewById(R.id.txt_nama_kab);
        rvDaftarKab=(RecyclerView)findViewById(R.id.rv_daftar_kab);
        layoutManager=new LinearLayoutManager(this);
        rvDaftarKab.setLayoutManager(layoutManager);
        Intent dapet=getIntent();
        provinsinya=(Provinsi)dapet.getSerializableExtra("kode");
        txtNamaKab.setText(provinsinya.getNama());
        kodenya=provinsinya.getId();
        apiInterface2=ApiClient.ambilData().create(ApiInterface.class);
        Call<SemuaKabupaten>call=apiInterface2.getkota_kabupaten(kodenya);
        call.enqueue(new Callback<SemuaKabupaten>() {
            @Override
            public void onResponse(Call<SemuaKabupaten> call, Response<SemuaKabupaten> response) {
                xxx=response.body();
                kabupaten=xxx.getKota_kabupaten();
                kabupatenAdapter=new KabupatenAdapter(kabupaten,KabupatenActivity.this);
                rvDaftarKab.setAdapter(kabupatenAdapter);
            }

            @Override
            public void onFailure(Call<SemuaKabupaten> call, Throwable t) {

            }
        });

    }
}