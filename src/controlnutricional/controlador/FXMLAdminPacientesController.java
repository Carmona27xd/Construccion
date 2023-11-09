/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlnutricional.controlador;

import controlnutricional.modelo.pojo.Paciente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Carmona
 */
public class FXMLAdminPacientesController implements Initializable {
    
    private int idNutriologo;

    @FXML
    private TextField tfBuscarPaciente;
    @FXML
    private TableView<Paciente> twTablaPacientes;
    @FXML
    private TableColumn<?, ?> tcNombre;
    @FXML
    private TableColumn<?, ?> tcApellidoPaterno;
    @FXML
    private TableColumn<?, ?> tcApellidoMaterno;
    @FXML
    private TableColumn<?, ?> tcEstatura;
    @FXML
    private TableColumn<?, ?> tcFechaNacimineto;
    @FXML
    private TableColumn<?, ?> tcCorreo;
    @FXML
    private TableColumn<?, ?> tcMunicipio;
    @FXML
    private TableColumn<?, ?> tcEstado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void inicializarInformacion(int idNutriologo){
        this.idNutriologo = idNutriologo;
    }
    
    private void configurarTabla(){
        this.tcNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.tcApellidoPaterno.setCellValueFactory(new PropertyValueFactory("apellidoPaterno"));
        this.tcApellidoMaterno.setCellValueFactory(new PropertyValueFactory("apellidoMaterno"));
        this.tcCorreo.setCellValueFactory(new PropertyValueFactory("correo"));
        this.tcEstatura.setCellValueFactory(new PropertyValueFactory("estatura"));
        
        
    }

    @FXML
    private void ivVolver(MouseEvent event) {
    }

    @FXML
    private void btAgregar(ActionEvent event) {
    }

    @FXML
    private void btModificar(ActionEvent event) {
    }

    @FXML
    private void btEliminar(ActionEvent event) {
    }
    
}
