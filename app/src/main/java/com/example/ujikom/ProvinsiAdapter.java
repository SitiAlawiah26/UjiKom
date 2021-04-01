package com.example.ujikom;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class ProvinsiAdapter extends  RecyclerView.Adapter<ProvinsiAdapter.ProvinsiHolder>{
    List<Provinsi> provinsinya;
    Activity activity;

    public ProvinsiAdapter(List<Provinsi> provinsinya,Activity activity){
        this.provinsinya= provinsinya;
        this.activity=activity;
    }


    @NonNull
    @Override
    public ProvinsiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.rv_item,parent,false);
        return  new ProvinsiHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ProvinsiHolder holder, final int position) {
        holder.btnNama.setText(provinsinya.get(position).getNama());
        holder.btnNama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Provinsi provinsi=provinsinya.get(position);
                Intent pindah = new Intent(activity,KabupatenActivity.class);
                pindah.putExtra("kode", provinsi);
                view.getContext().startActivity(pindah);

            }
        });

    }

    @Override
    public int getItemCount() {
        return provinsinya.size();
    }

    static class ProvinsiHolder extends RecyclerView.ViewHolder{
        Button btnNama;

        public ProvinsiHolder(@NonNull View itemView) {
            super(itemView);
            btnNama=(Button)itemView.findViewById(R.id.btn_nama);
        }
    }
}
