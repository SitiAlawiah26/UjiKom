package com.example.ujikom;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class KabupatenAdapter extends RecyclerView.Adapter<KabupatenAdapter.KabupatenHolder> {
    List<Kabupaten> kabupatenList;
    Activity activity;

    public KabupatenAdapter(List<Kabupaten> kabupatenList, Activity activity) {
        this.kabupatenList = kabupatenList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public KabupatenHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.rv_item_kab,parent,false);
        return new KabupatenHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KabupatenHolder holder, final int position) {
        holder.btnKab.setText(kabupatenList.get(position).getNama());
        holder.btnKab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                Kabupaten kabnya=kabupatenList.get(position);
                Intent pindah = new Intent(activity,KecamatanActivity.class);
                pindah.putExtra("kode", kabnya);
                view.getContext().startActivity(pindah);
            }
        });



    }

    @Override
    public int getItemCount() {
        return kabupatenList.size();
    }

    static class KabupatenHolder extends RecyclerView.ViewHolder {
        Button btnKab;

        public KabupatenHolder(@NonNull View itemView) {
            super(itemView);
            btnKab=(Button)itemView.findViewById(R.id.btn_nama_kab);
        }
    }
}
