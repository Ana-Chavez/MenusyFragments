package com.example.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mascotas.adapter.MascotaAdaptador;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity {

    private RecyclerView rvFavoritos;
    private ArrayList<Mascota> mascotasFavoritas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        rvFavoritos = findViewById(R.id.rvFavoritos);
        rvFavoritos.setLayoutManager(new LinearLayoutManager(this));

        inicializarListaFavoritas();
        inicializarAdaptador();

        // Volver a la Activity Lista
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void inicializarListaFavoritas() {
        mascotasFavoritas = new ArrayList<>();
        mascotasFavoritas.add(new Mascota("Catty", R.drawable.perro, 455));
        mascotasFavoritas.add(new Mascota("Ronny", R.drawable.perro2, 301));
        mascotasFavoritas.add(new Mascota("Frida", R.drawable.perro3, 212));
        mascotasFavoritas.add(new Mascota("Rocky", R.drawable.perro4, 455));
        mascotasFavoritas.add(new Mascota("Coco", R.drawable.perro5, 123));
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador;
        adaptador = new MascotaAdaptador(mascotasFavoritas,this);
        rvFavoritos.setAdapter(adaptador);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}