/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlnutricional.modelo.pojo;

/**
 *
 * @author Carmona
 */
public class Nutriologo {
    
    private Integer idNutriologo;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String numPersonal;
    private String password;
    private String cedula; 

    public Nutriologo(Integer idNutriologo, String nombre, String apellidoPaterno, 
            String apellidoMaterno, String numPersonal, String password, String cedula) {
        this.idNutriologo = idNutriologo;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numPersonal = numPersonal;
        this.password = password;
        this.cedula = cedula;
    }

    public Nutriologo() {
    }

    public Integer getIdNutriologo() {
        return idNutriologo;
    }

    public void setIdNutriologo(Integer idNutriologo) {
        this.idNutriologo = idNutriologo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNumPersonal() {
        return numPersonal;
    }

    public void setNumPersonal(String numPersonal) {
        this.numPersonal = numPersonal;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
}
