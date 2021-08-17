/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author dahia
 */
public class ConsultasHangar extends BaseDatos {

    //atributos
    private PreparedStatement sentenciaSQL;
    private ResultSet resultadoConsulta;

    //metodos
    public Hangar buscarHangar() {
//*0 creatr objeto tipo hangar
        Hangar hangar = new Hangar();
        //1 conectar bd
        Connection conexion = conectarBD();

        // definir el string con la consulta Sql
        String consulta = "SELECT * FROM hangares";

        //intetrno hacer lo que estoy programando
        try {
            // decir a bs que se prepare con la consulta
            sentenciaSQL = conexion.prepareStatement(consulta);
            //5. ejecuto la consulta
            resultadoConsulta = sentenciaSQL.executeQuery();

            //6. depuro los datos que llegan
            if (resultadoConsulta.next()) {
                hangar.setCodigoHangar(resultadoConsulta.getInt("codigoHangar"));
                hangar.setCuposTotales(resultadoConsulta.getInt("cuposTotales"));
                hangar.setCuposDisponibles(resultadoConsulta.getInt("cuposDisponibles"));
                hangar.setCuposReservados(resultadoConsulta.getInt("cuposReservados"));
                return hangar;
            } else {
                return null;
            }

        } catch (Exception error) {
            System.out.println("Error consultando registro " + error);
            return null;
        } finally {
            try {
                conexion.close();
            } catch (Exception error) {
                System.out.println("error: " + error);
            }

        }
    }

    public void actualizarHangar(Hangar hangar) {

        Connection conexion = conectarBD();

        String consulta = "UPDATE hangares SET cuposDisponibles=?, cuposReservados=? WHERE codigoHangar=160 ";

        try {

            sentenciaSQL = conexion.prepareStatement(consulta);

            sentenciaSQL.setInt(1, hangar.getCuposDisponibles());
            sentenciaSQL.setInt(2, hangar.getCuposReservados());

            int resultado = sentenciaSQL.executeUpdate();

        } catch (Exception error) {
            System.out.println("Error actualizando el registro " + error);

        } finally {
            try {
                conexion.close();
            } catch (Exception error) {
                System.out.println("error: " + error);
            }

        }
    }

}
