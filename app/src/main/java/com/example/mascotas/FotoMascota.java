package com.example.mascotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FotoMascota {
    private int imagen;
    private int likes;

    public FotoMascota(int imagen, int likes) {
        this.imagen = imagen;
        this.likes = likes;
    }

    public int getImagen() {
        return imagen;
    }

    public int getLikes() {
        return likes;
    }
}
