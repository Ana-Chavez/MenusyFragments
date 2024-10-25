package com.example.mascotas.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mascotas.Mascota;
import com.example.mascotas.R;
import com.example.mascotas.adapter.MascotaAdaptador;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ListaFragment extends Fragment {

    private RecyclerView rvMascotas;
    private ArrayList<Mascota> mascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_lista, container, false);

        rvMascotas = v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializaAdaptador();

        return v;
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Catty", R.drawable.perro, 455));
        mascotas.add(new Mascota("Ronny", R.drawable.perro2, 301));
        mascotas.add(new Mascota("Frida", R.drawable.perro3, 212));
        mascotas.add(new Mascota("Rocky", R.drawable.perro4, 445));
        mascotas.add(new Mascota("Coco", R.drawable.perro5, 123));
    }

    public void inicializaAdaptador(){
        MascotaAdaptador adaptador;
        adaptador = new MascotaAdaptador(mascotas, getActivity());
        rvMascotas.setAdapter(adaptador);
    }
}
