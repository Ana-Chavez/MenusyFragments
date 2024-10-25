package com.example.mascotas.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mascotas.FotoMascota;
import com.example.mascotas.R;
import com.example.mascotas.adapter.FotosPerfilAdapter;

import java.util.ArrayList;


public class PerfilFragment extends Fragment {

    private ImageView ivFotoPerfil;
    private TextView tvNombrePerfil;
    private RecyclerView rvFotos;
    private ArrayList<FotoMascota> fotos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        ivFotoPerfil = v.findViewById(R.id.ivFotoPerfil);
        tvNombrePerfil = v.findViewById(R.id.tvNombrePerfil);
        rvFotos = v.findViewById(R.id.rvFotos);

        ivFotoPerfil.setImageResource(R.mipmap.foto_perfil);
        tvNombrePerfil.setText("Pelusa");


        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        rvFotos.setLayoutManager(glm);

        inicializarFotos();
        inicializaAdaptador();

        return v;
    }

    public void inicializarFotos(){
        fotos = new ArrayList<>();

        fotos.add(new FotoMascota(R.mipmap.perro6,5));
        fotos.add(new FotoMascota(R.mipmap.perro6,10));
        fotos.add(new FotoMascota(R.mipmap.perro6,6));
        fotos.add(new FotoMascota(R.mipmap.perro6,2));
        fotos.add(new FotoMascota(R.mipmap.perro6,8));
        fotos.add(new FotoMascota(R.mipmap.perro6,15));
        fotos.add(new FotoMascota(R.mipmap.perro6,4));
        fotos.add(new FotoMascota(R.mipmap.perro6,7));
        fotos.add(new FotoMascota(R.mipmap.perro6,9));

    }

    public void inicializaAdaptador(){
        FotosPerfilAdapter adapter;
        adapter = new FotosPerfilAdapter(fotos);
        rvFotos.setAdapter(adapter);
    }
}