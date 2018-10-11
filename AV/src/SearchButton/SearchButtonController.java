package SearchButton;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import sample.Dictionary;
import sample.DictionaryMangement;

import java.net.URL;
import java.util.ResourceBundle;


public class SearchButtonController implements Initializable {
    @FXML
    private JFXTextField textField;
    @FXML
    private JFXButton button;
    @FXML
    private Label wordFound;
    @FXML

    public void searchButton(ActionEvent event) {
        String foundWord = new String(textField.getText());
        System.out.println(DictionaryMangement.dictionaryLockup(foundWord));
        if(DictionaryMangement.dictionaryLockup(foundWord).compareTo("No Word") == 0) {
            wordFound.setText("No Word");
        } else {
            wordFound.setText((DictionaryMangement.dictMange.foundWord(Dictionary.dict.listWord, foundWord)));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DictionaryMangement.dictMange.insertFromFiletest();
    }
}
