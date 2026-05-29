package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidad");
        EntityManager em = emf.createEntityManager();

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // Crear Pou inicial
        Pou pou = new Pou("MiPou");
        em.getTransaction().begin();
        em.persist(pou);
        em.getTransaction().commit();

        int opcion;
        do {
            System.out.println("\nEstado de " + pou.getNombre() + ":");
            System.out.println("Hambre: " + pou.getHambre());
            System.out.println("Felicidad: " + pou.getFelicidad());
            System.out.println("Suciedad: " + pou.getSuciedad());
            System.out.println("Energía: " + pou.getEnergia());

            System.out.println("\nMenú:");
            System.out.println("1. Dar de comer");
            System.out.println("2. Bañar");
            System.out.println("3. Jugar");
            System.out.println("4. Dormir");
            System.out.println("5. Acariciar");
            System.out.println("0. Salir");
            opcion = sc.nextInt();

            boolean obedece = random.nextInt(100) >= 20; // 80% obedece
            if (!obedece) {
                System.out.println(pou.getNombre() + " no obedeció. Pierde 10 de felicidad.");
                pou.setFelicidad(pou.getFelicidad() - 10);
            } else {
                switch (opcion) {
                    case 1 -> {
                        pou.setHambre(pou.getHambre() - 20);
                        pou.setEnergia(pou.getEnergia() + 10);
                        pou.setSuciedad(pou.getSuciedad() + 5);
                        System.out.println("Le diste de comer.");
                    }
                    case 2 -> {
                        pou.setSuciedad(0);
                        System.out.println("Lo bañaste.");
                    }
                    case 3 -> {
                        pou.setHambre(pou.getHambre() + 20);
                        pou.setEnergia(pou.getEnergia() - 20);
                        pou.setSuciedad(pou.getSuciedad() + 20);
                        pou.setFelicidad(pou.getFelicidad() + 15);
                        System.out.println("Jugaste con él.");
                    }
                    case 4 -> {
                        pou.setEnergia(pou.getEnergia() + 30);
                        pou.setHambre(pou.getHambre() + 10);
                        System.out.println("Lo hiciste dormir.");
                    }
                    case 5 -> {
                        pou.setFelicidad(pou.getFelicidad() + 10);
                        System.out.println("Lo acariciaste.");
                    }
                }
            }

            // Guardar cambios en BD
            em.getTransaction().begin();
            em.merge(pou);
            em.getTransaction().commit();

        } while (opcion != 0);

        em.close();
        emf.close();
    }
}
