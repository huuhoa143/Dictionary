package SearchButton;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainSearchButton extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Stage window;
    Scene scene1, scene2;
    @Override
    public void start(Stage primaryStage) {
        try {

            Parent parent = FXMLLoader.load(getClass().getResource("SearchButton.fxml"));
            Scene scene = new Scene(parent);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
