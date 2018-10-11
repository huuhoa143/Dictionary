package AddButton;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
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

import java.net.URL;
import java.util.ResourceBundle;

public class AddButtonController implements Initializable {
    @FXML
    JFXTextField textFieldWord;
    @FXML
    JFXTextField textFieldExlain;
    @FXML
    JFXButton button;


    public void AddWord(ActionEvent event) {
        String wordTarget = textFieldWord.getText();
        String wordExplain = textFieldExlain.getText();
        String foundWord = DictionaryMangement.dictMange.foundWord(Dictionary.dict.listWord, wordTarget);
        if(foundWord == "Khong co")
        {
            Dictionary.dict.listWord = DictionaryMangement.dictMange.AddWord(wordTarget, wordExplain);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Add Button");
            alert.setHeaderText(null);
            alert.setContentText("Bạn đã thêm từ thành công");
            alert.showAndWait();
        }
        else {
            try {
                Parent parent = FXMLLoader.load(getClass().getResource("/SearchButtonExtends/searchButtonExtends.fxml"));
                Scene scene = new Scene(parent);
                Stage windowAlert = (Stage)((Node)event.getSource()).getScene().getWindow();
                windowAlert.setScene(scene);
                windowAlert.show();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e);
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DictionaryMangement.dictMange.insertFromFiletest();
    }
}
