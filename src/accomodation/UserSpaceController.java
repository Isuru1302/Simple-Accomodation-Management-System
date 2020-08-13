/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accomodation;

import com.jfoenix.controls.JFXButton;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Crazydude
 */
public class UserSpaceController implements Initializable {

    @FXML
    private TableColumn<ManagerPortal, String> col_id;
    @FXML
    private TableColumn<ManagerPortal, String> col_leaseNumber;
    @FXML
    private TableColumn<ManagerPortal, String> col_hallName;
    @FXML
    private TableColumn<ManagerPortal, String> col_hallNo;
    @FXML
    private TableColumn<ManagerPortal, String> col_roomNo;
    @FXML
    private TableColumn<ManagerPortal, String> col_studentName;
    @FXML
    private TableColumn<ManagerPortal, String> col_studentId;
    @FXML
    private TableColumn<ManagerPortal, String> col_occupancyStatus;
    @FXML
    private TableColumn<ManagerPortal, String> col_cleaningStatus;
    @FXML
    private JFXButton hall1_btn;
    @FXML
    private TableView<ManagerPortal> tableUser;

    private Connection conn = null;
    private PreparedStatement ps = null;
    private Statement st = null;
    private ResultSet rs = null;

    ObservableList<ManagerPortal> data = FXCollections.observableArrayList();
    ObservableList<String> data2 = FXCollections.observableArrayList("Occupied", "Unoccupied");

    private DbConnection dc;
    @FXML
    private VBox logout;
    @FXML
    private JFXButton hall2_btn;
    @FXML
    private JFXButton hall3_btn;
    @FXML
    private JFXButton logout_btn;
    @FXML
    private JFXButton clear_btn;
    @FXML
    private TextField hallName;
    @FXML
    private TextField roomNumber;
    @FXML
    private TextField studentName;
    @FXML
    private TextField studentId;
    @FXML
    private TextField leaseNumber;
    @FXML
    private ComboBox<String> combo_box;
    @FXML
    private GridPane gridPane;
    @FXML
    private JFXButton update_btn;
    @FXML
    private JFXButton delete_btn;
    @FXML
    private TextField id;
    @FXML
    private TextField cleaningStatus;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        combo_box.setValue("");
        combo_box.setItems(data2);

        setCellValueFromTableToTextField();
        try {

            conn = DbConnection.getConnection();

            rs = conn.createStatement().executeQuery("SELECT * FROM maindb LIMIT 20");

            while (rs.next()) {

                data.add(new ManagerPortal(rs.getString("id"), rs.getString("leaseNumber"), rs.getString("hallName"),
                        rs.getString("hallNumber"), rs.getString("roomNumber"), rs.getString("studentName"),
                        rs.getString("studentId"), rs.getString("occupancyStatus"), rs.getString("cleaningStatus")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserSpaceController.class.getName()).log(Level.SEVERE, null, ex);
        }

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_leaseNumber.setCellValueFactory(new PropertyValueFactory<>("leaseNumber"));
        col_hallName.setCellValueFactory(new PropertyValueFactory<>("hallName"));
        col_hallNo.setCellValueFactory(new PropertyValueFactory<>("hallNumber"));
        col_roomNo.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        col_studentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        col_studentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        col_occupancyStatus.setCellValueFactory(new PropertyValueFactory<>("occupancyStatus"));
        col_cleaningStatus.setCellValueFactory(new PropertyValueFactory<>("cleaningStatus"));

        tableUser.setItems(null);
        tableUser.setItems(data);

    }

    @FXML
    private void hall1_btnPress(ActionEvent event) {
        data.clear();
        try {

            conn = DbConnection.getConnection();

            rs = conn.createStatement().executeQuery("SELECT * FROM maindb LIMIT 20");

            while (rs.next()) {

                data.add(new ManagerPortal(rs.getString("id"), rs.getString("leaseNumber"), rs.getString("hallName"),
                        rs.getString("hallNumber"), rs.getString("roomNumber"), rs.getString("studentName"),
                        rs.getString("studentId"), rs.getString("occupancyStatus"), rs.getString("cleaningStatus")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserSpaceController.class.getName()).log(Level.SEVERE, null, ex);
        }

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_leaseNumber.setCellValueFactory(new PropertyValueFactory<>("leaseNumber"));
        col_hallName.setCellValueFactory(new PropertyValueFactory<>("hallName"));
        col_hallNo.setCellValueFactory(new PropertyValueFactory<>("hallNumber"));
        col_roomNo.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        col_studentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        col_studentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        col_occupancyStatus.setCellValueFactory(new PropertyValueFactory<>("occupancyStatus"));
        col_cleaningStatus.setCellValueFactory(new PropertyValueFactory<>("cleaningStatus"));

        tableUser.setItems(null);
        tableUser.setItems(data);

    }

    @FXML
    private void hall2_btnPress(ActionEvent event) {
        
        data.clear();
        try {

            conn = DbConnection.getConnection();

            rs = conn.createStatement().executeQuery("SELECT * FROM maindb LIMIT 20 OFFSET 20");

            while (rs.next()) {

                data.add(new ManagerPortal(rs.getString("id"), rs.getString("leaseNumber"), rs.getString("hallName"),
                        rs.getString("hallNumber"), rs.getString("roomNumber"), rs.getString("studentName"),
                        rs.getString("studentId"), rs.getString("occupancyStatus"), rs.getString("cleaningStatus")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserSpaceController.class.getName()).log(Level.SEVERE, null, ex);
        }

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_leaseNumber.setCellValueFactory(new PropertyValueFactory<>("leaseNumber"));
        col_hallName.setCellValueFactory(new PropertyValueFactory<>("hallName"));
        col_hallNo.setCellValueFactory(new PropertyValueFactory<>("hallNumber"));
        col_roomNo.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        col_studentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        col_studentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        col_occupancyStatus.setCellValueFactory(new PropertyValueFactory<>("occupancyStatus"));
        col_cleaningStatus.setCellValueFactory(new PropertyValueFactory<>("cleaningStatus"));

        tableUser.setItems(null);
        tableUser.setItems(data);
    }

    @FXML
    private void hall3_btnPress(ActionEvent event) {
        data.clear();
        try {

            conn = DbConnection.getConnection();

            rs = conn.createStatement().executeQuery("SELECT * FROM maindb LIMIT 20 OFFSET 40");

            while (rs.next()) {

                data.add(new ManagerPortal(rs.getString("id"), rs.getString("leaseNumber"), rs.getString("hallName"),
                        rs.getString("hallNumber"), rs.getString("roomNumber"), rs.getString("studentName"),
                        rs.getString("studentId"), rs.getString("occupancyStatus"), rs.getString("cleaningStatus")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserSpaceController.class.getName()).log(Level.SEVERE, null, ex);
        }

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_leaseNumber.setCellValueFactory(new PropertyValueFactory<>("leaseNumber"));
        col_hallName.setCellValueFactory(new PropertyValueFactory<>("hallName"));
        col_hallNo.setCellValueFactory(new PropertyValueFactory<>("hallNumber"));
        col_roomNo.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        col_studentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        col_studentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        col_occupancyStatus.setCellValueFactory(new PropertyValueFactory<>("occupancyStatus"));
        col_cleaningStatus.setCellValueFactory(new PropertyValueFactory<>("cleaningStatus"));

        tableUser.setItems(null);
        tableUser.setItems(data);
    }

    @FXML
    private void clean_btnPress(ActionEvent event) {
        
        data.clear();
        try {
            
         conn = DbConnection.getConnection();
        
        rs = conn.createStatement().executeQuery("SELECT * FROM maindb");
        
        while(rs.next()){
            
           data.add(new ManagerPortal(rs.getString("id"),rs.getString("leaseNumber"),rs.getString("hallName"),
             rs.getString("hallNumber"),rs.getString("roomNumber"), rs.getString("studentName"),
             rs.getString("studentId"),rs.getString("occupancyStatus"), rs.getString("cleaningStatus") ));
        }
        
        
        } catch (SQLException ex) {
            Logger.getLogger(UserSpaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_leaseNumber.setCellValueFactory(new PropertyValueFactory<>("leaseNumber"));
        col_hallName.setCellValueFactory(new PropertyValueFactory<>("hallName"));
        col_hallNo.setCellValueFactory(new PropertyValueFactory<>("hallNumber"));
        col_roomNo.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        col_studentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        col_studentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        col_occupancyStatus.setCellValueFactory(new PropertyValueFactory<>("occupancyStatus"));
        col_cleaningStatus.setCellValueFactory(new PropertyValueFactory<>("cleaningStatus"));
        

        tableUser.setItems(null);
        tableUser.setItems(data);

    }

    @FXML
    private void logout_btnPress(ActionEvent event) {

        Stage stage = (Stage) logout_btn.getScene().getWindow();
        stage.close();

    }

    private void setCellValueFromTableToTextField() {

        tableUser.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                ManagerPortal p1 = tableUser.getItems().get(tableUser.getSelectionModel().getSelectedIndex());
                id.setText(p1.getId());
                hallName.setText(p1.getHallName());
                roomNumber.setText(p1.getRoomNumber());
                leaseNumber.setText(p1.getLeaseNumber());
                studentName.setText(p1.getStudentName());
                studentId.setText(p1.getStudentId());
                cleaningStatus.setText(p1.getCleaningStatus());
                combo_box.setValue(p1.getOccupancyStatus());
            }

        });
    }

    @FXML
    private void update_btnPress(ActionEvent event) {
        
        try {
          String OStatus = rs.getString("occupancyStatus");
           //String CStatus = rs.getString("cleaningStatus");
//            if(OStatus.equals("Unoccupied") && CStatus.equals("Clean") || CStatus.equals("Dirty"))
       // if(combo_box.getValue() == "Unoccupied" && cleaningStatus.getText() == "clean" || cleaningStatus.getText() == "Dirty")
            System.out.println(combo_box.getValue());
       if( OStatus.equals("Unoccupied") && (cleaningStatus.equals("Clean")|| cleaningStatus.equals("Dirty")))
        {
            theQuery("update maindb set leaseNumber = '" + leaseNumber.getText() + "',studentName = '" + studentName.getText() + "', studentId = '" + studentId.getText() + "', occupancyStatus = '" + combo_box.getValue() + "' where id = " + id.getText());
        }        
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Cannot create Lease! room either occupied or offline.");
            alert.showAndWait();
        }
        //theQuery("update maindb set leaseNumber = '" + leaseNumber.getText() + "',studentName = '" + studentName.getText() + "', studentId = '" + studentId.getText() + "', occupancyStatus = '" + combo_box.getValue() + "' where id = " + id.getText());

           
            
        } catch (Exception ex) {
        }
        refreshTable();
        leaseNumber.clear();
        hallName.clear();
        roomNumber.clear();
        studentName.clear();
        studentId.clear();
        combo_box.setValue("");
    }

    public void theQuery(String query) {

        try {
            conn = DbConnection.getConnection();
                
            st = conn.createStatement();
            st.executeUpdate(query);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Update Successful");
            alert.showAndWait();
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }

    @FXML
    private void delete_btnPress(ActionEvent event) {

        try {

            theQuery("update maindb set leaseNumber = '',studentName = '', studentId = '', occupancyStatus = 'Unoccupied' where id = " + id.getText());
        } catch (Exception ex) {
        }
        refreshTable();
    }
    
    public void refreshTable() {
        data.clear();
        try {

            conn = DbConnection.getConnection();
            rs = conn.createStatement().executeQuery("SELECT * FROM maindb ");

            while (rs.next()) {

                data.add(new ManagerPortal(rs.getString("id"), rs.getString("leaseNumber"), rs.getString("hallName"),
                        rs.getString("hallNumber"), rs.getString("roomNumber"), rs.getString("studentName"),
                        rs.getString("studentId"), rs.getString("occupancyStatus"), rs.getString("cleaningStatus")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserSpaceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableUser.setItems(null);
        tableUser.setItems(data);

    }
}
