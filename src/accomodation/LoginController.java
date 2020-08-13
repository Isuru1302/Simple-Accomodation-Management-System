/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accomodation;

//import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import static javafx.scene.input.DataFormat.URL;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 *
 * @author Crazydude
 */
public class LoginController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private Label close;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton login;
    
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    
     @Override
        public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conn=  DbConnection.getConnection();
    }

    @FXML
    void closeTab(MouseEvent event) {

        System.exit(0);
    }
    
 
    @FXML
    void login(ActionEvent event) throws SQLException, IOException {
             
        

    String UserName = username.getText().trim();
    String Password = password.getText().trim();


    String sql = "SELECT * FROM login WHERE username = ? OR email = ? AND password = ?" ;
    try {
        ps = conn.prepareStatement(sql);
        ps.setString(1, UserName);
        ps.setString(2,UserName);
        ps.setString(3, Password);
        
        rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("satus");
            if(id == 1){
            Parent root = FXMLLoader.load(getClass().getResource("UserSpace.fxml"));     
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Manager");
            stage.show();
            }
            else if(id == 2){
            Parent root = FXMLLoader.load(getClass().getResource("WardenSpace.fxml"));     
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Warden");
            stage.show();
                
            }
        } else {
          
          Alert alert = new Alert(AlertType.ERROR);
          alert.setTitle("ERROR");
          alert.setHeaderText(null);
          alert.setContentText("The Username/Password is Incorrect!");
          alert.showAndWait();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
        username.clear();
        password.clear();
}}




        

       



