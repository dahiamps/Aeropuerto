/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.util.Scanner;
import modelos.Propietario;

/**
 *
 * @author dahia
 */
public class VistaPropietario {

    public Propietario activarVista() {
        Scanner leer = new Scanner(System.in);
        //int cedula, metodo;

        Propietario propietario = new Propietario();

        System.out.println("Bienvenido al hangar 160");

        System.out.println("Digite la cedula del propietario ");
        propietario.setCedula(leer.nextInt());
        //cedula = leer.nextInt();
        System.out.println("Digite los nombres del propietario ");
        propietario.setNombre(leer.next());
        //String nombre = leer.next();
        System.out.println("Digite el metodo de pado (1-Contado / 2-Credito)");
        propietario.setMetodoPago(leer.nextInt());
        //metodo = leer.nextInt();
        
        return propietario;
    }

}
