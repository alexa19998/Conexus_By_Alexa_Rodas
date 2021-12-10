package com.example.conexus;

public class Visualizador {

    //declaracion de atributos del objeto
    private int imagen;
    private String titulo;
    private String enunciado;


    // Constructor para crear las preguntas

    public Visualizador( int imagen, String titulo, String enunciado) {

        this.imagen = imagen;
        this.enunciado = enunciado;
        this.titulo = titulo;
    }

    public Visualizador( int imagen, String titulo) {

        this.imagen = imagen;
        this.titulo = titulo;
    }

    // Getter y Setter

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }



}

