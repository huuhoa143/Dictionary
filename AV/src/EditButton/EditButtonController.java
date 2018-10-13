package EditButton;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import sample.Dictionary;
import sample.DictionaryMangement;
import sample.Word;

import java.net.URL;
import java.util.ResourceBundle;

public class EditButtonController implements Initializable {
    @FXML
    JFXTextField wordTarget;
    @FXML
    JFXTextField wordExplain;
    @FXML
    JFXButton buttonEdit;

    public void editButton() {
        String targetText =wordTarget.getText();
        String explainText = wordExplain.getText();
        String foundWord = DictionaryMangement.dictMange.listHasWord(Dictionary.dict.listWord, targetText);

        if(!foundWord.equals("No Word")) {
            Dictionary.dict.listWord = DictionaryMangement.dictMange.EditWord(targetText, explainText);
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
