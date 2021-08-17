/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import modelos.ConsultasHangarAvion;
import modelos.HangarAvion;

/**
 *
 * @author dahia
 */
public class ControladorHangarAvion {
    private ConsultasHangarAvion modelo = new ConsultasHangarAvion();
    
    public void registrarHangarAvion(HangarAvion hangarAvion,String matriculaAvion,String cuposReservados){
        int celda=Integer.parseInt(cuposReservados);
        int celdaAsignada=celda+1;
         //System.out.println("hola "+ celda);
         hangarAvion.setNumeroCeldas(celdaAsignada);
        modelo.insertarHangarAvion(hangarAvion, matriculaAvion, celdaAsignada);
    }
    
    public void actualizarHangarAvion(HangarAvion hangarAvion,String cuposReservados){
        //debo traer los cupos reservados y hacer que este valor ingrece a la celda del avion en el hangar
       
        int celda=Integer.parseInt(cuposReservados);
        int celdaAsignada=celda+1;
         //System.out.println("hola "+ celda);
         hangarAvion.setNumeroCeldas(celdaAsignada);
        
    }
    
    
    
}
