package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Controller {



    @FXML
    public TextArea query;

    @FXML
    public TextField inserts;

    @FXML
    public TextArea result;

    @FXML
    public Label statusBar;


    public void pasteInserts(ActionEvent actionEvent) throws IOException {

        try {
            result.setText(SQLInsertsFormatter.format(SQLInsertsFormatter.pasteInserts(query.getText(), inserts.getText())));
            if ("".equals(result.getText())) {
                statusBar.setText("");
                return;
            }
            result.selectAll();
            result.copy();
            result.deselect();
            statusBar.setText("Copied to clipboard");
            statusBar.setVisible(true);

        } catch (Exception e) {
            statusBar.setText("Something went wrong");
            statusBar.setVisible(true);
            e.printStackTrace();
        }

    }
}
