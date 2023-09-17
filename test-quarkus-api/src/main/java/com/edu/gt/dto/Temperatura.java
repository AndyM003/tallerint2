/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.gt.dto;

/**
 *
 * @author wcordova
 */
public class Temperatura {

    private String cuidad;
    private int minima;
    private int maxima;

    public Temperatura(String cuidad, int minima, int maxima) {
        this.cuidad = cuidad;
        this.minima = minima;
        this.maxima = maxima;
    }

    public Temperatura(String cuidad) {
        this.cuidad = cuidad;
    }

    @Override
    public String toString() {
        return "Temperatura{" + "cuidad=" + cuidad + ", minima=" + minima + ", maxima=" + maxima + '}';
    }

    public String getCuidad() {
        return cuidad;
    }

    public void setCuidad(String cuidad) {
        this.cuidad = cuidad;
    }

    public int getMinima() {
        return minima;
    }

    public void setMinima(int minima) {
        this.minima = minima;
    }

    public int getMaxima() {
        return maxima;
    }

    public void setMaxima(int maxima) {
        this.maxima = maxima;
    }

}
