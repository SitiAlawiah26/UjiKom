package com.example.ujikom;

import java.io.Serializable;

public class Kabupaten implements Serializable {
    private int id;
    private int id_provinsi;
    private String nama;

    public Kabupaten(int id, int id_provinsi, String nama) {
        this.id = id;
        this.id_provinsi = id_provinsi;
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_provinsi() {
        return id_provinsi;
    }

    public void setId_provinsi(int id_provinsi) {
        this.id_provinsi = id_provinsi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
