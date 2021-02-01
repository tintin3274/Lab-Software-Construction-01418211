package dictionary;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class ExportController {
    @FXML TextArea exportTextArea;
    @FXML Label displayFormatLabel;
    @FXML Button copyButton;
    private String formatName;
    private String text;

    @FXML public void initialize(){
        Platform.runLater(() -> {
            displayFormatLabel.setText("Dictionary "+formatName+" :");
            exportTextArea.setText(text);
        });

    }

    @FXML private void handleCopyButtonOnAction(ActionEvent event){
        CopyStringToClipboard(text);
    }

    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }

    public void setText(String text) {
        this.text = text;
    }

    private void CopyStringToClipboard(String str){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection strSel = new StringSelection(str);
        clipboard.setContents(strSel, null);
    }
}
