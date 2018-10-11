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
        String wordFound = DictionaryMangement.dictMange.foundWordabc(Dictionary.dict.listWord,wordDelete);
        System.out.println(wordFound);
        System.out.println(wordDelete);
        System.out.println(wordFound.equals("Khong co"));
        Word w = new Word(wordDelete, DictionaryMangement.dictMange.foundWord(Dictionary.dict.listWord, wordDelete), DictionaryMangement.dictMange.foundSound(Dictionary.dict.listWord, wordDelete));

        //Dictionary.dict.listWord = Dictionary.dict.listWord.re(w);

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DictionaryMangement.dictMange.insertFromFiletest();
    }
}
