/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author dahia
 */
public class ConsultasHangarAvion extends BaseDatos {

    private PreparedStatement sentenciaSQL;

    public void insertarHangarAvion(HangarAvion hangaravion, String matriculaAvion,int celda) {

        //obtener la fecha y hora actual
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaActual=format.format(date);
        
        //Rutina para generar el numero de Celda
        
        Connection conexion = conectarBD();
        String consulta = "INSERT INTO hangaresaviones(codigoHangar, matriculaAvion, fechaIngreso, numeroCeldas)"
                + " VALUES (?,?,?,?)";
       //INSERT INTO `hangares-aviones`(`codigoHangar`, `matriculaAvion`, `fechaIngreso`, `numeroCeldas`) VALUES ('160','AAA11A','2021-08-05 00:00:00','value-4') 
       //INSERT INTO hangares-aviones(codigoHangar,matriculaAvion,fechaIngreso,numeroCeldas)"
                //+ "VALUES(?,?,?,?)"
        try {
           
            sentenciaSQL=conexion.prepareStatement(consulta);
            
            sentenciaSQL.setInt(1,160);
            sentenciaSQL.setString(2,matriculaAvion);
            sentenciaSQL.setString(3, fechaActual);
            sentenciaSQL.setInt(4, celda);
            int resultado=sentenciaSQL.executeUpdate();
        } catch (Exception error) {
            System.out.println("Error al insertar el avion en el hangar" + error);
        } finally {
            try {
                conexion.close();
            } catch (Exception error) {
                System.out.println("error: " + error);
            }
        }
    }

}
