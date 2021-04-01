package com.example.ujikom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.List;

public class KecamatanAdapter extends RecyclerView.Adapter<KecamatanAdapter.KecamatanHolder> {
    List<Kecamatan> kecamatanList;
    Activity activity;

    public KecamatanAdapter(List<Kecamatan> kecamatanList, Activity activity) {
        this.kecamatanList = kecamatanList;
        this.activity = activity;
    }


    @NonNull
    @Override
    public KecamatanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.rv_item_kec, parent, false);
        return new KecamatanHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KecamatanHolder holder, final int position) {
        holder.btnKec.setText(kecamatanList.get(position).getNama());

    }

    @Override
    public int getItemCount() {
        return kecamatanList.size();
    }


    static class KecamatanHolder extends RecyclerView.ViewHolder {
        Button btnKec;

        public KecamatanHolder(@NonNull View itemView) {
            super(itemView);
            btnKec = (Button) itemView.findViewById(R.id.btn_nama_kec);
        }
    }
}


