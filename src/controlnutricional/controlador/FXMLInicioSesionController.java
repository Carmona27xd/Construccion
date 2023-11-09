/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package controlnutricional.controlador;

import controlnutricional.modelo.ConexionBD;
import controlnutricional.modelo.dao.NutriologoDAO;
import controlnutricional.modelo.pojo.RespuestaLogin;
import controlnutricional.utils.Utilidades;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Carmona
 */
public class FXMLInicioSesionController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private TextField tfPassword;
    @FXML
    private Label lbErrorUsuario;
    @FXML
    private Label lbErrorPassword;
    @FXML
    private TextField tfNumPersonal;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        verificarConexion();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }

    public FXMLInicioSesionController() {
        
    }
    
    //temporal
    private void verificarConexion(){
        Connection conexionPrueba = ConexionBD.obtenerConexion();
        if (conexionPrueba != null) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Prueba");
            alerta.setHeaderText(null);
            alerta.setContentText("Hay conexion");
            alerta.showAndWait();
        }
    }
    
    @FXML
    private void btnIniciarSesion(ActionEvent event) {
        String usuario = tfNumPersonal.getText();
        String password = tfPassword.getText();
        
        if (tfPassword.getText().isEmpty()) {
            lbErrorPassword.setText("Ingrese una contraseña");
        }
        if (tfNumPersonal.getText().isEmpty()) {
            lbErrorUsuario.setText("Ingrese un usuario");
        }
        
        verificarAcceso(usuario, password);
    }
    
    private void verificarAcceso(String numPersonaString, String password){
        RespuestaLogin autenticacion = NutriologoDAO.iniciarSesion(numPersonaString, password);
        if (!autenticacion.isError()) {
            Utilidades.mostrarAlertaSimple("Autenticacion", "Bienvendido al sistema",
                    Alert.AlertType.INFORMATION);
            mostrarPantallaPrincipal(autenticacion);
        }else{
            Utilidades.mostrarAlertaSimple("Autenticacion", "Credenciales incorrectas",
                    Alert.AlertType.WARNING);
        }
    }
    
    private void mostrarPantallaPrincipal(RespuestaLogin usuario){
        try {
            Stage escenarioActual = (Stage) tfNumPersonal.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(controlnutricional.ControlNutricional.class.getResource("vista/FXMLHome.fxml"));
            Parent vista = loader.load();
            FXMLHomeController home = loader.getController();
            
            home.inicializarInformacion(usuario.getNutriologo());
            Scene escena = new Scene(vista);
            escenarioActual.setScene(escena);
            escenarioActual.show();
            escenarioActual.setTitle("Home");
        } catch (IOException e) {
            Utilidades.mostrarAlertaSimple("Error", "Error al mostrar la ventana",
                    Alert.AlertType.INFORMATION);
        }
    }
}
