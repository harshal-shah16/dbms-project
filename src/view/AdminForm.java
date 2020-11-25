package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminForm implements Initializable {
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

  }

  public void admin(javafx.event.ActionEvent actionEvent) {

  }

  public void addUser(ActionEvent actionEvent) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/view/AddDoctor.fxml"));
    Stage primaryStage = new Stage();
    primaryStage.setTitle("Add Doctor");
    primaryStage.setScene(new Scene(root, 500, 500));
    primaryStage.show();
    ((Node)(actionEvent.getSource())).getScene().getWindow().hide();

  }
}
