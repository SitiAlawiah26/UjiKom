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

public class KecamatanActivity extends AppCompatActivity {
    TextView txtNamaKec;
    RecyclerView rvDaftarKec;
    RecyclerView.LayoutManager layoutManager;
    int kodenya;
    ApiInterface apiInterface3;
    Kabupaten kabnyaa;
    SemuaKecamatan zzz;
    List<Kecamatan> kecamatan;
    KecamatanAdapter KecamatanAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kecamatan);
        txtNamaKec=(TextView) findViewById(R.id.txt_nama_kec);
        rvDaftarKec=(RecyclerView) findViewById(R.id.rv_daftar_kec);
        layoutManager=new LinearLayoutManager(this);
        rvDaftarKec.setLayoutManager(layoutManager);
        Intent dapet=getIntent();
        kabnyaa= (Kabupaten) dapet.getSerializableExtra( "kode");
        txtNamaKec.setText(kabnyaa.getNama());
        kodenya=kabnyaa.getId();
        apiInterface3=ApiClient.ambilData().create(ApiInterface.class);
        Call<SemuaKecamatan> call=apiInterface3.getkecamatannya(kodenya);
        call.enqueue(new Callback<SemuaKecamatan>() {
            @Override
            public void onResponse(Call<SemuaKecamatan> call, Response<SemuaKecamatan> response) {
                zzz=response.body();
                kecamatan=zzz.getKecamatan();
                KecamatanAdapter=new KecamatanAdapter(kecamatan,KecamatanActivity.this);
                rvDaftarKec.setAdapter(KecamatanAdapter);
            }

            @Override
            public void onFailure(Call<SemuaKecamatan> call, Throwable t) {

            }
        });

    }
}