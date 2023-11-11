/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlnutricional.controlador;

import controlnutricional.modelo.dao.PacienteDAO;
import controlnutricional.modelo.pojo.Paciente;
import controlnutricional.utils.Utilidades;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Carmona
 */
public class FXMLAdminPacientesController implements Initializable {
    
    private int idNutriologo;
    private ObservableList<Paciente> pacientes;

    @FXML
    private TextField tfBuscarPaciente;
    @FXML
    private TableView<Paciente> twTablaPacientes;
    @FXML
    private TableColumn tcNombre;
    @FXML
    private TableColumn tcApellidoPaterno;
    @FXML
    private TableColumn tcApellidoMaterno;
    @FXML
    private TableColumn tcEstatura;
    @FXML
    private TableColumn tcFechaNacimineto;
    @FXML
    private TableColumn tcCorreo;
    @FXML
    private TableColumn tcMunicipio;
    @FXML
    private TableColumn tcEstado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        configurarTabla();
    }

    public void inicializarInformacion(int idNutriologo){
        this.idNutriologo = idNutriologo;
        obtenerInformacionPacientes();
    }
    
    private void configurarTabla(){
        this.tcNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.tcApellidoPaterno.setCellValueFactory(new PropertyValueFactory("apellidoPaterno"));
        this.tcApellidoMaterno.setCellValueFactory(new PropertyValueFactory("apellidoMaterno"));
        this.tcCorreo.setCellValueFactory(new PropertyValueFactory("correo"));
        this.tcEstatura.setCellValueFactory(new PropertyValueFactory("estatura"));
        this.tcEstado.setCellValueFactory(new PropertyValueFactory("estado"));
        this.tcMunicipio.setCellValueFactory(new PropertyValueFactory("municipio"));
        this.tcFechaNacimineto.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
    }
    
    private void obtenerInformacionPacientes(){
        try {
            HashMap<String, Object> respuesta = PacienteDAO
                    .obtenerPacientesNutriologo(idNutriologo);
            if (!(boolean)respuesta.get("error")) {
                pacientes = FXCollections.observableArrayList();
                ArrayList<Paciente> lista = (ArrayList<Paciente>) respuesta.get("pacientes");
                pacientes.addAll(lista);
                twTablaPacientes.setItems(pacientes);
            }else{
                Utilidades.mostrarAlertaSimple("Error", "" + respuesta.get("mensaje"),
                        Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void ivVolver(MouseEvent event) {
        Stage escenario = (Stage) tfBuscarPaciente.getScene().getWindow();
        escenario.close();
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
