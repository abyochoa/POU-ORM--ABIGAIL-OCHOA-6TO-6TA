package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "pou")
public class Pou {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int hambre;
    private int felicidad;
    private int suciedad;
    private int energia;

    public Pou() {}

    public Pou(String nombre) {
        this.nombre = nombre;
        this.hambre = 50;
        this.felicidad = 50;
        this.suciedad = 50;
        this.energia = 50;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getHambre() { return hambre; }
    public void setHambre(int hambre) { this.hambre = hambre; }
    public int getFelicidad() { return felicidad; }
    public void setFelicidad(int felicidad) { this.felicidad = felicidad; }
    public int getSuciedad() { return suciedad; }
    public void setSuciedad(int suciedad) { this.suciedad = suciedad; }
    public int getEnergia() { return energia; }
    public void setEnergia(int energia) { this.energia = energia; }
}
