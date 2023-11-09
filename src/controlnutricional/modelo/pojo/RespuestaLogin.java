/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlnutricional.modelo.pojo;

/**
 *
 * @author Carmona
 */
public class RespuestaLogin {
    
    private boolean error;
    private String mensaje;
    private Nutriologo nutriologo;

    public RespuestaLogin() {
    }

    public RespuestaLogin(boolean error, String mensaje, Nutriologo nutriologo) {
        this.error = error;
        this.mensaje = mensaje;
        this.nutriologo = nutriologo;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Nutriologo getNutriologo() {
        return nutriologo;
    }

    public void setNutriologo(Nutriologo nutriologo) {
        this.nutriologo = nutriologo;
    }
    
    
}
