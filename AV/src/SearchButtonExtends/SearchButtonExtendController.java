package SearchButtonExtends;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.DictionaryMangement;

public class SearchButtonExtendController {

    @FXML
    JFXButton backButton;
    @FXML
    JFXButton searchButton;

    public void clickButtonBack(ActionEvent event) {
        try {
            Parent searchParent = FXMLLoader.load(getClass().getResource("/AddButton/addButton.fxml"));
            Scene searchScene = new Scene(searchParent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(searchScene);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
    public void clickButtonSearch(ActionEvent event) {
        try {
            Parent sampleParent = FXMLLoader.load(getClass().getResource("/SearchButton/SearchButton.fxml"));
            Scene sampleScene = new Scene(sampleParent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(sampleScene);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
