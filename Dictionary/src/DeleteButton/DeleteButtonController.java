package DeleteButton;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import sample.Dictionary;
import sample.DictionaryMangement;
import sample.Word;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteButtonController implements Initializable {
    @FXML
    JFXTextField textField;
    @FXML
    JFXButton buttonDelete;

    public void DeleteWord(ActionEvent event) {
        String wordDelete = textField.getText();
        String foundWordDelete = DictionaryMangement.dictMange.listHasWord(Dictionary.dict.listWord, wordDelete);
        if(foundWordDelete == "No Word") {
            DictionaryMangement.dictMange.changeScene(getClass().getResource("/DeleteButtonExtends2/deleteButtonExtends2.fxml"), event);
        }
        else {
             Dictionary.dict.listWord = DictionaryMangement.dictMange.deleteWord(wordDelete);
            DictionaryMangement.dictMange.changeScene(getClass().getResource("/DeleteButtonExtends/deleteButtonExtend.fxml"), event);
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DictionaryMangement.dictMange.insertFromFiletest();
    }
}
