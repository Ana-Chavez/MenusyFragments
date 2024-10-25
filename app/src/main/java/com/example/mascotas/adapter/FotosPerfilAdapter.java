package com.example.mascotas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mascotas.FotoMascota;
import com.example.mascotas.R;

import java.util.ArrayList;

public class FotosPerfilAdapter extends RecyclerView.Adapter<FotosPerfilAdapter.FotoViewHolder> {
    private ArrayList<FotoMascota>fotos;

    public FotosPerfilAdapter(ArrayList<FotoMascota> fotos) {
        this.fotos = fotos;
    }

    @NonNull
    @Override
    public FotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_foto_mascota,parent,false);
        return new FotoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FotoViewHolder holder, int position) {
        FotoMascota foto = fotos.get(position);
        holder.ivFoto.setImageResource(foto.getImagen());
        holder.tvRating.setText(String.valueOf(foto.getLikes()));
    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    public static class FotoViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto, ivHueso;
        TextView tvRating;

        public FotoViewHolder(@NonNull View itemView){
            super (itemView);
            ivFoto = itemView.findViewById(R.id.ivFotoPerfil);
            tvRating = itemView.findViewById(R.id.tvRating);
            ivHueso = itemView.findViewById(R.id.ivHueso);
        }
    }
}
