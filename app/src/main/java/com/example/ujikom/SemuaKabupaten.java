package com.example.ujikom;

import java.util.List;

public class SemuaKabupaten {
    private List<Kabupaten> kota_kabupaten;

    public SemuaKabupaten(List<Kabupaten> kota_kabupaten) {
        this.kota_kabupaten = kota_kabupaten;
    }

    public List<Kabupaten> getKota_kabupaten() {
        return kota_kabupaten;
    }

    public void setKota_kabupaten(List<Kabupaten> kota_kabupaten) {
        this.kota_kabupaten = kota_kabupaten;
    }

}
