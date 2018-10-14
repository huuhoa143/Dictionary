package DeleteButtonExtends2;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import sample.DictionaryMangement;

public class DeleteButtonExtends2Controller {
    @FXML
    JFXButton button;

    public void BackButton(ActionEvent event) {
        DictionaryMangement.dictMange.changeScene(getClass().getResource("/DeleteButton/deleteButton.fxml"), event);
    }
}
