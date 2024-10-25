package com.example.mascotas.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mascotas.Mascota;
import com.example.mascotas.R;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    private ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgMascota.setImageResource(mascota.getImagen());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvRaiting.setText(String.valueOf(mascota.getRating()));

        holder.huesoBlanco.setOnClickListener(v -> {
            mascota.setRating(mascota.getRating() + 1);
            holder.tvRaiting.setText(String.valueOf(mascota.getRating()));
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMascota, huesoAmarillo, huesoBlanco;
        TextView tvNombre, tvRaiting;

        public MascotaViewHolder(@NonNull View itemView){
            super (itemView);
            imgMascota = itemView.findViewById(R.id.imgMascota);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            huesoBlanco = itemView.findViewById(R.id.icBlanco);
            huesoAmarillo = itemView.findViewById(R.id.icNaranja);
            tvRaiting = itemView.findViewById(R.id.ratingMascota);
        }
    }
}
