/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeropuerto;

import controladores.ControladorAvion;
import controladores.ControladorHangar;
import controladores.ControladorHangarAvion;
import controladores.ControladorPropietario;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;
import modelos.Avion;
import modelos.Hangar;
import modelos.HangarAvion;
import modelos.Propietario;
import vistas.VistaAvion;
import vistas.VistaHangarAvion;
import vistas.VistaPropietario;

/**
 *
 * @author dahia
 */
public class Aeropuerto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);

        // como capturar la fecha del sistema en java//hacer la tabla hangar-aviones
        //buscar info hangar
        System.out.println("Escoge el procedimiento a realizar  ");
        System.out.println("1 - Ver informacion del hangar");
        System.out.println("2 - Ingresar un nuevo registro en el hangar ");
        System.out.println("3 - Salir");
        int opc = leer.nextInt();

        ControladorHangar controladorHangar = new ControladorHangar();
        Hangar hangar = new Hangar();
        while (opc < 3) {
            if (opc == 1) {

                hangar = controladorHangar.consultarInformacionHangar();
            } else {
                if (hangar.getCuposDisponibles() > 0) {
                    //2. registro en bd el propietario
                    VistaPropietario vistaPropietario = new VistaPropietario();
                    Propietario propietario = vistaPropietario.activarVista();
                    //llamar al controlador
                    ControladorPropietario controladorPropietario = new ControladorPropietario();
                    controladorPropietario.registrarPropietario(propietario);
                    //3. registrar avion en bd
                    //hacer el de avion
                    VistaAvion vistaAvion = new VistaAvion();
                    Avion avion = vistaAvion.activarVista();
                    //Controlador
                    ControladorAvion controladorAvion = new ControladorAvion();
                    controladorAvion.registrarAvion(avion);

                    ControladorHangarAvion controladorHAngarAvion = new ControladorHangarAvion();

                    HangarAvion hangarAvion = new HangarAvion();
                    String numCelda = String.valueOf(hangar.getCuposReservados());

                    controladorHAngarAvion.registrarHangarAvion(hangarAvion, avion.getMatricula(), numCelda);

                    controladorHangar.actualizarHangar(hangar);

                } else {
                    System.out.println("no hay cupos disponible (1 -  para verificar) ");
                }
            }
            System.out.println("Deseas escoger otro procedimiento a realizar  ");
            System.out.println("1 - Ver informacion del hangar");
            System.out.println("2 - Ingresar un nuevo registro en el hangar ");
            System.out.println("3 - Salir");
            opc = leer.nextInt();
        }

        System.out.println("Hasta luego");

        /*
        ControladorHangar controladorHangar = new ControladorHangar();
        Hangar hangar = controladorHangar.consultarInformacionHangar();

        if (hangar.getCuposDisponibles() > 0) {
            //2. registro en bd el propietario
            VistaPropietario vistaPropietario = new VistaPropietario();
            Propietario propietario = vistaPropietario.activarVista();
            //llamar al controlador
            ControladorPropietario controladorPropietario = new ControladorPropietario();
            controladorPropietario.registrarPropietario(propietario);
            //3. registrar avion en bd
            //hacer el de avion
            VistaAvion vistaAvion = new VistaAvion();
            Avion avion = vistaAvion.activarVista();
            //Controlador
            ControladorAvion controladorAvion = new ControladorAvion();
            controladorAvion.registrarAvion(avion);

            ControladorHangarAvion controladorHAngarAvion = new ControladorHangarAvion();
            
            HangarAvion hangarAvion = new HangarAvion();
                String numCelda= String.valueOf(hangar.getCuposReservados());

            controladorHAngarAvion.registrarHangarAvion(hangarAvion, avion.getMatricula(), numCelda);
            
            controladorHangar.actualizarHangar(hangar);
            
        } else {
            System.out.println("no tenemos cupos disponibles");
        }*/
        //Objeto tipo vista
        /*    VistaHangarAvion vistaHangarAvion = new VistaHangarAvion();
        HangarAvion hangarAvion = vistaHangarAvion.activarVista();

        ControladorHangarAvion controladorHAngarAvion = new ControladorHangarAvion();
        controladorHAngarAvion.registrarHangarAvion(matriculaAvion*/

 /*
  
                //crear objeto de tipo vista
                VistaPropietario vistaPropietario = new VistaPropietario();
                Propietario propietario = vistaPropietario.activarVista();

                //llamar al controlador
                ControladorPropietario controladorPropietario = new ControladorPropietario();
                controladorPropietario.registrarPropietario(propietario);

       
                //hacer el de avion
                VistaAvion vistaAvion = new VistaAvion();
                Avion avion = vistaAvion.activarVista();

                //Controlador
                ControladorAvion controladorAvion = new ControladorAvion();
                controladorAvion.registrarAvion(avion);
         */
    }

}
