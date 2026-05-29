package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "alimentos")
public class Alimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private int energia;
    private int suciedad;
    private int felicidad;
    private int hambre;

    public Alimento() {}

    public Alimento(String nombre, int energia, int suciedad, int felicidad, int hambre) {
        this.nombre = nombre;
        this.energia = energia;
        this.suciedad = suciedad;
        this.felicidad = felicidad;
        this.hambre = hambre;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getEnergia() { return energia; }
    public void setEnergia(int energia) { this.energia = energia; }
    public int getSuciedad() { return suciedad; }
    public void setSuciedad(int suciedad) { this.suciedad = suciedad; }
    public int getFelicidad() { return felicidad; }
    public void setFelicidad(int felicidad) { this.felicidad = felicidad; }
    public int getHambre() { return hambre; }
    public void setHambre(int hambre) { this.hambre = hambre; }
}
