package DeleteButtonExtends;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sample.DictionaryMangement;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteButtonExtendController implements Initializable {
    @FXML
    JFXButton button;

    public void backButton(ActionEvent event) {
        DictionaryMangement.dictMange.changeScene(getClass().getResource("/DeleteButton/deleteButton.fxml"), event);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
