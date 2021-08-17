/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.util.Scanner;
import modelos.Avion;


/**
 *
 * @author dahia
 */
public class VistaAvion {

    public Avion activarVista() {
        Scanner leer = new Scanner(System.in);

        Avion avion = new Avion();

        System.out.println("Digite la matricula del avion");
        avion.setMatricula(leer.next());
        System.out.println("Digite el modelo del avion");
        avion.setModelo(leer.next());
        System.out.println("Digite la cedula del propietario");
        avion.setCedula(leer.nextInt());
        System.out.println("Digite el tipo de contrato");
        avion.setContrato(leer.nextInt());
        return avion;
    }
}
