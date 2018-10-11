package EditButton;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import sample.Dictionary;
import sample.DictionaryMangement;

import java.net.URL;
import java.util.ResourceBundle;

public class EditButtonController implements Initializable {
    @FXML
    JFXTextField wordTarget;
    @FXML
    JFXTextField wordExplain;
    @FXML
    JFXButton buttonEdit;

    public void editButton(ActionEvent event) {
        String targetText = new String(wordTarget.getText());
        String explainText = new String(wordExplain.getText());
        //System.out.println(targetText);
        System.out.println(DictionaryMangement.dictionaryLockup(targetText));
        String a = new String(DictionaryMangement.dictMange.foundWordabc(Dictionary.dict.listWord, targetText));
        System.out.println(a == targetText);
        System.out.println(a.compareTo(targetText) == 0);
        System.out.println(targetText.equals(a));
        if(targetText.equals(DictionaryMangement.dictionaryLockup(targetText))) {
            DictionaryMangement.dictMange.EditWord(Dictionary.dict.listWord, targetText, explainText);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Edit Button");
            alert.setHeaderText(null);
            alert.setContentText("Bạn đã sửa từ thành công");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Edit Button");
            alert.setHeaderText(null);
            alert.setContentText("Từ bạn nhập không có trong từ điển mời bạn nhập lại");
            alert.showAndWait();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DictionaryMangement.dictMange.insertFromFiletest();
    }
}
