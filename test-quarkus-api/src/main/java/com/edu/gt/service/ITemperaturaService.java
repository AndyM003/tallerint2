/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edu.gt.service;

import com.edu.gt.dto.Temperatura;
import java.util.List;

/**
 *
 * @author wcordova
 */
public interface ITemperaturaService {

    List<Temperatura> obtenerTemperaturas();

    void addTemperatura(Temperatura t);

    boolean isEmpty();

    int maxima();

}
