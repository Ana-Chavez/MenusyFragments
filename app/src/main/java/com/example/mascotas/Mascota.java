package com.example.mascotas;

public class Mascota {
    private String nombre;
    private int imagen;
    private int rating;

    public Mascota(String nombre, int imagen, int rating) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.rating = rating;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
