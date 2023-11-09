/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlnutricional.controlador;

import controlnutricional.modelo.pojo.Nutriologo;
import controlnutricional.utils.Utilidades;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Carmona
 */
public class FXMLHomeController implements Initializable {
    
    private Nutriologo nutriologoSesion; 
    
    @FXML
    private Label lbNombreNutriologo;
    @FXML
    private Label lbNumPersonal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void inicializarInformacion(Nutriologo nutriologoSesion){
        this.nutriologoSesion = nutriologoSesion;
        if (this.nutriologoSesion != null) {
            String nombreCompleto = this.nutriologoSesion.getNombre() + " " +
                    this.nutriologoSesion.getApellidoPaterno() + " " +
                    this.nutriologoSesion.getApellidoPaterno();
            lbNombreNutriologo.setText(nombreCompleto);
            lbNumPersonal.setText(this.nutriologoSesion.getNumPersonal());
            
        }
    }

    @FXML
    private void clicCerrarSesion(MouseEvent event) {
        try {
            Stage escenarioActual = (Stage) lbNombreNutriologo.getScene().getWindow();
            Parent vista = FXMLLoader.load(
                controlnutricional.ControlNutricional.class.getResource("vista/FXMLInicioSesion.fxml"));
            Scene scene = new Scene(vista);
            escenarioActual.setScene(scene);
            escenarioActual.setTitle("Iniciar sesion");
            escenarioActual.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }

    @FXML
    private void btIrAdminPacientes(ActionEvent event) {
        try {
            FXMLLoader loader = Utilidades.cargarVista("vista/FXMLAdminPacientes.fxml");
            Parent vista = loader.load();
            Scene escena = new Scene(vista);
            FXMLAdminPacientesController controlador = loader.getController();
            controlador.inicializarInformacion(nutriologoSesion.getIdNutriologo());
            
            Stage escenario = new Stage();
            escenario.setScene(escena);
            escenario.setTitle("Pacientes");
            escenario.initModality(Modality.APPLICATION_MODAL);
            escenario.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
