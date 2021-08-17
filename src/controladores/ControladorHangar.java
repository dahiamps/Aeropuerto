/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import modelos.ConsultasHangar;
import modelos.Hangar;
import vistas.VistaHangar;

/**
 *
 * @author dahia
 */
public class ControladorHangar {

    private ConsultasHangar modelo = new ConsultasHangar();
    private VistaHangar vista = new VistaHangar();

    public Hangar consultarInformacionHangar() {
        Hangar hangar = modelo.buscarHangar();
        vista.activarVista(hangar);
        return hangar;
    }
    
    public void actualizarHangar(Hangar hangar){
        
        int cuposDisponiblesAntesDeMatricula=hangar.getCuposDisponibles();
        int cuposDisponiblesDespuesDeMatricula=cuposDisponiblesAntesDeMatricula-1;
        int cuposReservadosAntes=hangar.getCuposReservados();
        int cuposReservadosDespues=cuposReservadosAntes+1;
        
        
        hangar.setCuposDisponibles(cuposDisponiblesDespuesDeMatricula);
        hangar.setCuposReservados(cuposReservadosDespues);
        //hangar.getCuposDisponibles();//-1
        modelo.actualizarHangar(hangar);
    }
}
