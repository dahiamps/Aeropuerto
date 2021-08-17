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
public class ConsultasPropietario extends BaseDatos{
    
        private PreparedStatement sentenciaSQL;
        
            public void insertarPropietario(Propietario propietario) {
        //3. establecer conexion con la base de datos
        Connection conexion = conectarBD();

        String consulta = "INSERT INTO propietarios(cedulaPropietario,nombre,metodoPago)"
                + "VALUES(?,?,?)";
        //2.intento llevar datos
        try {
            //3. asociar el ps a la conexion
            sentenciaSQL = conexion.prepareStatement(consulta);
            //4. diferenciar la consulta(personalizar la consulta)
            sentenciaSQL.setInt(1, propietario.getCedula());
            sentenciaSQL.setString(2, propietario.getNombre());
            sentenciaSQL.setInt(3, propietario.getMetodoPago());
            //5.ejecutar la consulta
            int resultado = sentenciaSQL.executeUpdate();
            //6. validar el resultado
            if (resultado > 0) {
                System.out.println("Exito registrando el propietario");
            } else {
                System.out.println("Error al agregar el registro");
            }
        } catch (Exception error) {
            System.out.println("No se pudo registrar el propietario " + error);
        } finally {
            try {
                conexion.close();
            } catch (Exception error) {
                System.out.println("error: " + error);
            }

        }

    }


    
}
