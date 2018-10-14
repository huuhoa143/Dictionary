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
    private TextArea wordFound;
    @FXML
    private JFXButton button;

    public void searchButton() {
        String text = textField.getText();
        String foundWord = DictionaryMangement.dictMange.listHasWord(Dictionary.dict.listWord, text);

        if(foundWord == "No Word") {
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
