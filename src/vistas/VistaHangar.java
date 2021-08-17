/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import modelos.Hangar;

/**
 *
 * @author dahia
 */
public class VistaHangar {

    public void activarVista(Hangar hangar) {
        
        System.out.println("Los datos del hangar\n");

        System.out.println("Cupos totales del hangar: "+hangar.getCuposTotales()+"\n");
        System.out.println("Cupos disponibles: "+hangar.getCuposDisponibles()+"\n");
        System.out.println("Cupos reservados: "+hangar.getCuposReservados()+"\n");
    }
}
