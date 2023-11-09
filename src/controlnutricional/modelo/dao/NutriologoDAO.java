/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlnutricional.modelo.dao;

import controlnutricional.modelo.ConexionBD;
import controlnutricional.modelo.pojo.Nutriologo;
import controlnutricional.modelo.pojo.RespuestaLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carmona
 */
public class NutriologoDAO {
    
    public static RespuestaLogin iniciarSesion(String numPersonal, String password){
        RespuestaLogin respuesta = new RespuestaLogin();
        Connection conexionBD = ConexionBD.obtenerConexion();
        if (conexionBD != null) {
            try {
                String consulta = "SELECT idNutriologo, nombre, apellidoPaterno, apellidoMaterno,"
                    + "numPersonal, cedula FROM nutriologo WHERE numPersonal = ? AND loginPassword = ?";
                PreparedStatement prepararConsulta = conexionBD.prepareStatement(consulta);
                prepararConsulta.setString(1, numPersonal);
                prepararConsulta.setString(2, password);
                ResultSet resultadoSentencia = prepararConsulta.executeQuery();
                if(resultadoSentencia.next()){
                    respuesta.setError(false);
                    respuesta.setMensaje("Credenciales correctas");
                    Nutriologo nutriologo = new Nutriologo();
                    nutriologo.setIdNutriologo(resultadoSentencia.getInt("idNutriologo"));
                    nutriologo.setNombre(resultadoSentencia.getString("nombre"));
                    nutriologo.setApellidoPaterno(resultadoSentencia.getString("apellidoPaterno"));
                    nutriologo.setApellidoPaterno(resultadoSentencia.getString("apellidoMaterno"));
                    nutriologo.setNumPersonal(resultadoSentencia.getString("numPersonal"));
                    nutriologo.setCedula(resultadoSentencia.getString("cedula"));
                    respuesta.setNutriologo(nutriologo);
                    conexionBD.close();
                }else{
                    respuesta.setError(true);
                    respuesta.setMensaje("Usuario no encontrado, verifica las credenciales");
                }
                conexionBD.close();
            } catch (SQLException e) {
                e.printStackTrace();
                respuesta.setMensaje("Error de conexion con la base de datos");
            } finally {
                //conexionBD.close();
            }
        }else{
            respuesta.setMensaje("Error en la conexion"); 
        }
        return respuesta;
    }
}
