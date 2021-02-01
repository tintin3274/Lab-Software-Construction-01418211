package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {
    @FXML Label nameLabel;
    @FXML Button submitBtn;
    @FXML TextField nameField;

    @FXML public void initialize(){
        nameField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nameLabel.setText(nameField.getText());
            }
        });
    }

    @FXML public void handleSubmitBtnOnAction(ActionEvent event) throws IOException {
        //nameLabel.setText(nameField.getText());
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("page2.fxml"));
        stage.setScene(new Scene(loader.load(), 300, 300));
        PageController controller =loader.getController();
        controller.setName(nameField.getText());
        stage.show();
    }

}
