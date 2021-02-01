package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PageController {
    @FXML Label label;

    public void setName(String name){
        label.setText(name);
    }

}
