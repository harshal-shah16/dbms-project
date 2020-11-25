package view;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.IllegalFormatConversionException;

import javax.swing.*;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import util.DBConnection;

public class AddDoctor {
  @FXML
  private TextField doctorID = null;

  @FXML
  private TextField firstName;

  @FXML
  private TextField lastName;

  @FXML
  private TextField specialty;

  @FXML
  public void addDoctor(javafx.event.ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
    Connection con = DBConnection.getCon();
    int doctorIDNumber = 0;
    try {
        doctorIDNumber = Integer.parseInt(doctorID.getText());
    }
    catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null,"Give a numeric value for doctor ID");
    }
    String doctorFirstName = firstName.getText();
    String doctorLastName = lastName.getText();
    String doctorSpecialty = specialty.getText();

    if (doctorIDNumber == 0 || doctorFirstName.isEmpty() || doctorLastName.isEmpty() || doctorSpecialty.isEmpty() ) {
      JOptionPane.showMessageDialog(null, "Please give valid details for all fields");
    }
    PreparedStatement stmt;
    String sql = "INSERT INTO doctors VALUES (?, ?, ?, ?)";
    stmt = con.prepareStatement(sql);
    stmt.setInt(1, doctorIDNumber);
    stmt.setString(2, doctorFirstName);
    stmt.setString(3, doctorLastName);
    stmt.setString(4, doctorSpecialty);
    int updateResult;
    try {
      updateResult = stmt.executeUpdate();
      JOptionPane.showMessageDialog(null, "Successfully added new doctor");
    }
    catch (SQLIntegrityConstraintViolationException e) {
      JOptionPane.showMessageDialog(null,"Doctor with same id already present" );
    }

  }

}
