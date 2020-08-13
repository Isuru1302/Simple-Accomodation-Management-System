/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accomodation;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
public class WardenSpaceController implements Initializable {

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
    private ResultSet rs = null;
    
    ObservableList<ManagerPortal> data = FXCollections.observableArrayList();
    ObservableList<String> data2 = FXCollections.observableArrayList("Clean", "Dirty","Offline");
    
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
    private GridPane gridPane;
    @FXML
    private JFXButton update_btn;
    @FXML
    private JFXButton delete_btn;
    @FXML
    private TextField id;
    @FXML
    private Label cleaningStatus;
    @FXML
    private ComboBox<String> combo_box2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        combo_box2.setValue("");
        combo_box2.setItems(data2);
        
        setCellValueFromTableToTextField();
       try {
            
         conn = DbConnection.getConnection();
        
        rs = conn.createStatement().executeQuery("SELECT * FROM maindb LIMIT 20");
        
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
    private void hall1_btnPress(ActionEvent event) {
        data.clear();
        try {
            
         conn = DbConnection.getConnection();
        
        rs = conn.createStatement().executeQuery("SELECT * FROM maindb LIMIT 20");
        
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
    private void hall2_btnPress(ActionEvent event) {
        data.clear();
        try {
            
         conn = DbConnection.getConnection();
        
        rs = conn.createStatement().executeQuery("SELECT * FROM maindb LIMIT 20 OFFSET 20");
        
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
    private void hall3_btnPress(ActionEvent event) {
        data.clear();
        try {
            
         conn = DbConnection.getConnection();
        
        rs = conn.createStatement().executeQuery("SELECT * FROM maindb LIMIT 20 OFFSET 40");
        
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
    
    private void setCellValueFromTableToTextField(){
        
        tableUser.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                
                ManagerPortal p1 = tableUser.getItems().get(tableUser.getSelectionModel().getSelectedIndex());
                id.setText(p1.getId());
                hallName.setText(p1.getHallName());
                roomNumber.setText(p1.getRoomNumber());
                leaseNumber.setText(p1.getLeaseNumber());
                studentName.setText(p1.getStudentName());
                studentId.setText(p1.getStudentId());
                combo_box2.setValue(p1.getCleaningStatus());
            }
        
        });
    }

    @FXML
    private void update_btnPress(ActionEvent event) {
        
        setCellValueFromTableToTextField();
        
         try{
         
           //theQuery("UPDATE maindb set leaseNumber = '"+leaseNumber.getText()+"',studentName = '"+studentName.getText()+"', studentId = '"+studentId.getText()+"' where id = '"+id.getText());
           theQuery("update maindb set leaseNumber = '"+leaseNumber.getText()+"',studentName = '"+studentName.getText()+"', studentId = '"+studentId.getText()+"', cleaningStatus = '"+combo_box2.getValue()+"' where id = "+id.getText());
         }
         catch(Exception ex){
         }
          refreshTable();
      }
    
    public void theQuery(String query){
      
      try{
          conn = DbConnection.getConnection();
         Statement st = null;
       // rs = conn.createStatement().executeQuery("SELECT * FROM maindb LIMIT 20 OFFSET 40");
        
         // conn = DriverManager.getConnection("jdbc:mysql://localhost/test_db","root","");
          st = conn.createStatement();
          st.executeUpdate(query);
          
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Update Successful");
                alert.showAndWait();
      }catch(Exception ex){
          //JOptionPane.showMessageDialog(null,ex.getMessage());
      }
  
  }

    @FXML
    private void delete_btnPress(ActionEvent event) {
        
        try{
          
             theQuery("update maindb set cleaningStatus = '' where id = "+id.getText());
         }
         catch(Exception ex){
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
