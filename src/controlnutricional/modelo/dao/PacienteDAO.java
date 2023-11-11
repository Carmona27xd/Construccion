/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlnutricional.modelo.dao;

import controlnutricional.modelo.ConexionBD;
import controlnutricional.modelo.pojo.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author Carmona
 */
public class PacienteDAO {
    
    public static HashMap<String,Object> obtenerPacientesNutriologo(Integer idNutriologo) throws SQLException{
        HashMap<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("error", true);
        Connection conexionBD = ConexionBD.obtenerConexion();
        if (conexionBD != null) {
            try {
                String consulta = "SELECT idPaciente, p.nombre, apellidoPaterno, apellidoMaterno, estatura, " + 
                "correo, fechaNacimiento, p.idMunicipio, m.nombre AS municipio, \n" +
                "m.idEstado, e.nombre AS estado \n " +
                "FROM \n" +
                "paciente p \n" +
                "INNER JOIN municipio m ON p.idMunicipio = m.idMunicipio \n" +
                "INNER JOIN estado e ON m.idEstado = e.idEstado \n" +
                "WHERE idNutriologo = ?";
                PreparedStatement prepararConsulta = conexionBD.prepareStatement(consulta);
                prepararConsulta.setInt(1, idNutriologo);
                ResultSet resultado = prepararConsulta.executeQuery();
                ArrayList<Paciente> pacientes = new ArrayList();
                respuesta.put("error", false);
                while (resultado.next()) {                    
                    Paciente paciente = new Paciente();
                    paciente.setIdPaciente(resultado.getInt("idPaciente"));
                    paciente.setNombre(resultado.getString("p.nombre"));
                    paciente.setApellidoPaterno(resultado.getString("apellidoPaterno"));
                    paciente.setApellidoMaterno(resultado.getString("apellidoMaterno"));
                    paciente.setEstatura(resultado.getInt("estatura"));
                    paciente.setCorreo(resultado.getString("correo"));
                    paciente.setFechaNacimiento(resultado.getString("fechaNacimiento"));
                    paciente.setIdEstado(resultado.getInt("idEstado"));
                    paciente.setIdNutriologo(resultado.getInt("idMunicipio"));
                    paciente.setEstado(resultado.getString("estado"));
                    pacientes.add(paciente);
                }
                respuesta.put("error", false);
                respuesta.put("pacientes", pacientes);
            } catch (Exception e) {
                respuesta.put("mensaje", e.getMessage());
            } finally{
                conexionBD.close();
            }
        }else{
            respuesta.put("respuesta", "Error en la conexion");
        }
        return respuesta;
    }
}
