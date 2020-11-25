package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginForm implements Initializable {
  @FXML
  private PasswordField password;

  @FXML
  private TextField userName;

  @FXML
  private Button btnLogin;

  Connection con = null;
  PreparedStatement pst;
  ResultSet rs;


  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

  }

  public void login(javafx.event.ActionEvent actionEvent) {
    String username = userName.getText();
    String pwd = password.getText();

    if (username.isEmpty() || pwd.isEmpty()) {
      JOptionPane.showMessageDialog(null, "Please enter Username/Password");
    }
    else {
      try {
        con = util.DBConnection.getCon();
        pst = con.prepareStatement("select * from users where username = ? and pwd = ?");
        pst.setString(1, username);
        pst.setString(2, pwd);
        rs = pst.executeQuery();
        if (rs.next()) {
          JOptionPane.showMessageDialog(null, "Login Success");
          Parent root = FXMLLoader.load(getClass().getResource("/view/AdminForm.fxml"));
          Stage primaryStage = new Stage();
          primaryStage.setTitle("Welcome Admin");
          primaryStage.setScene(new Scene(root, 500, 500));
          primaryStage.show();
          ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        }
        else {
          JOptionPane.showMessageDialog(null, "Login Failure - Please Try Again");
        }
      } catch (ClassNotFoundException | SQLException | IOException ex) {};
    }
  }
}
