package com.example.ujikom;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("provinsi")
    Call <SemuaProvinsi> getprovinsi();

    @GET("kota")
    Call <SemuaKabupaten> getkota_kabupaten(@Query("id_provinsi") int a);

    @GET("kecamatan")
    Call <SemuaKecamatan> getkecamatannya(@Query("id_kota") int a);




}
