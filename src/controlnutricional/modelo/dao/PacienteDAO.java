/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlnutricional.modelo.dao;

import controlnutricional.modelo.ConexionBD;
import java.sql.Connection;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author Carmona
 */
public class PacienteDAO {
    
    public static HashMap<String,Object> obtenerPacientesNutriologo(Integer idNutriologo){
        HashMap<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("error", true);
        Connection conexionBD = ConexionBD.obtenerConexion();
        if (conexionBD != null) {
            
        }else{
            respuesta.put("respuesta", "Error en la conexion");
        }
        return respuesta;
    }
}
