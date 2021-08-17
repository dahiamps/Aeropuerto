/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author dahia
 */
public class ConsultasAvion extends BaseDatos {

    private PreparedStatement sentenciaSQL;

    public void insertarAvion(Avion avion) {

        Connection conexion = conectarBD();

        String consulta = "INSERT INTO aviones(matriculaAvion,modeloAvion,cedulaPropietario,tipoContrato)"
                + "VALUES(?,?,?,?)";

        try {
            sentenciaSQL = conexion.prepareStatement(consulta);

            sentenciaSQL.setString(1, avion.getMatricula());
            sentenciaSQL.setString(2, avion.getModelo());
            sentenciaSQL.setInt(3, avion.getCedula());
            sentenciaSQL.setInt(4, avion.getContrato());

            int resultado = sentenciaSQL.executeUpdate();

            if (resultado > 0) {
                System.out.println("Exito registrando el avion");
            } else {
                System.out.println("Error al agregar el registro");
            }

        } catch (Exception error) {
            System.out.println("No se pudo registrar el avion " + error);
        } finally {
            try {
                conexion.close();
            } catch (Exception error) {
                System.out.println("error: " + error);
            }

        }

    }
}
