package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.voicerss.tts.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField textFieldSearch;
    @FXML
    private ListView<String> listView = new ListView<String>();
    @FXML
    private ListView<String> listViewMyWord = new ListView<String>();
    @FXML
    private Label labelWordFound;
    @FXML
    private TextArea labelWordExplain;
    @FXML
    private Label labelWordSound;
    @FXML
    private Label labelWordDefinition;
    @FXML
    private JFXButton buttonPronounce;
    @FXML
    private ImageView imageView;
    @FXML
    private MenuItem searchItem;
    @FXML
    private MenuItem deleteItem;
    @FXML
    private MenuItem addItem;
    @FXML
    private MenuItem editItem;
    @FXML
    private MenuItem aboutItem;

    /**
     * Cua so deleteWord
     */
    @FXML
    JFXTextField textField;
    @FXML
    JFXButton buttonDelete;

    /**
     * Cua so addWord
     */
    @FXML
    JFXTextField textFieldWord;
    @FXML
    JFXTextField textFieldExlain;
    @FXML
    JFXButton button;

    /**
     * Cua so searchWord
     */
    @FXML
    private JFXTextField textFieldExtra;
    @FXML
    private TextArea wordFoundExtra;
    @FXML
    private JFXButton buttonExtra;

    /**
     * Cua so editWord
     */
    @FXML
    JFXTextField wordTarget;
    @FXML
    JFXTextField wordExplain;
    @FXML
    JFXButton buttonEdit;

    /**
     * Hàm đưa ra các từ gợi ý sau khi nhập từ ở textField và listView
     */
    public void listSuggetion() {
        ArrayList<String> listWordInListView = new ArrayList<String>();
        String suggetWordExplain = textFieldSearch.getText();
        listWordInListView = DictionaryMangement.dictMange.arrayWordTarget(Dictionary.dict.listWord, suggetWordExplain);
        ObservableList<String> result = FXCollections.observableArrayList(listWordInListView);
        listView.setItems(result);
    }

    /**
     * Hàm đưa ra thông tin khi bấm vào các từ ở listView
     * @param event sự kiện
     */
    public void clickForInformationWord(MouseEvent event) {
        String info = listView.getSelectionModel().getSelectedItem();
        String a = new String();
        String b = new String();
        a  = DictionaryMangement.dictMange.foundWord(Dictionary.dict.listWord, info);
        b = DictionaryMangement.dictMange.foundSound(Dictionary.dict.listWord, info);
        labelWordFound.setText(info);
        labelWordExplain.setText(a);
        labelWordSound.setText(b);
        labelWordDefinition.setText("Định nghĩa:");
    }

    /**
     * Hàm phát âm
     * @param event sự kiện truyền vào
     * @throws Exception
     */
    public void clickForSound(MouseEvent event) throws Exception{
        //API gọi tới nhà cung cấp để lấy file phát âm theo từ khóa word
        VoiceProvider tts = new VoiceProvider("a3889c418b3d4b4fb32dec48e3d1cfec");
        String word = listView.getSelectionModel().getSelectedItem();
        VoiceParameters params = new VoiceParameters(word, Languages.English_UnitedStates);
        params.setCodec(AudioCodec.WAV);
        params.setFormat(AudioFormat.Format_44KHZ.AF_44khz_16bit_stereo);
        params.setBase64(false);
        params.setSSML(false);
        params.setRate(0);
        byte[] voice = tts.speech(params);

        // Lưu file âm thanh tải về vào file voice.mp3
        FileOutputStream fos = new FileOutputStream("src/output_mp3/voice.mp3");
        fos.write(voice, 0, voice.length);
        fos.flush();
        fos.close();

        // Mở file mp3 bằng FileInputStream
        String gongFile = "src/output_mp3/voice.mp3";
        InputStream in = new FileInputStream(gongFile);

        // Tạo audiostream từ FileInputStream
        AudioStream audioStream = new AudioStream(in);

        // Mở file âm thanh vừa tải về
        AudioPlayer.player.start(audioStream);
    }

    @FXML
    private void handleButtonSearch(ActionEvent event) {
        DictionaryMangement.dictMange.loadWindow(getClass().getResource("/SearchButton/SearchButton.fxml"), "Search", null);
    }
    @FXML
    private void handleButtonAdd(ActionEvent event) {
        DictionaryMangement.dictMange.loadWindow(getClass().getResource("/AddButton/addButton.fxml"), "Add", null);
    }
    @FXML
    private void handleButtonDelete(ActionEvent event) {
        DictionaryMangement.dictMange.loadWindow(getClass().getResource("/DeleteButton/deleteButton.fxml"), "Delete", null);
    }
    @FXML
    private void handleButtonEdit(ActionEvent event) {
        DictionaryMangement.dictMange.loadWindow(getClass().getResource("/EditButton/editButton.fxml"), "Edit", null);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(!location.toExternalForm().endsWith("sample.fxml")) return;
        DictionaryMangement.dictMange.insertFromFiletest();
        ObservableList<String> list= FXCollections.observableArrayList(DictionaryMangement.dictMange.listWordTarget(Dictionary.dict.listWord));
        listViewMyWord.setItems(list);
    }


    @FXML
    public void deleteMenuItem(ActionEvent event) {
        DictionaryMangement.dictMange.loadWindow(getClass().getResource("/DeleteButton/deleteButton.fxml"), "Delete", null);
    }
    @FXML
    public void searchMenuItem(ActionEvent event) {
        DictionaryMangement.dictMange.loadWindow(getClass().getResource("/SearchButton/SearchButton.fxml"), "Search", null);
    }
    @FXML
    public void addMenuItem(ActionEvent event) {
        DictionaryMangement.dictMange.loadWindow(getClass().getResource("/AddButton/addButton.fxml"), "Add", null);
    }
    @FXML
    public void editMenuItem(ActionEvent event) {
        DictionaryMangement.dictMange.loadWindow(getClass().getResource("/EditButton/editButton.fxml"), "Edit", null);
    }
    @FXML
    public void aboutMenuItem(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Information");
        alert.setHeaderText(null);
        alert.setContentText("Nguyễn Hữu Hoà" + "
				"Phan Tất Phúc");
        alert.showAndWait();
    }

    /**
     * Ham hien len cua so xoa tu
     * @param event su kien
     */
    public void DeleteWord(ActionEvent event) {
        String wordDelete = textField.getText();
        String foundWordDelete = DictionaryMangement.dictMange.listHasWord(Dictionary.dict.listWord, wordDelete);
        //System.out.println(foundWordDelete);
        if(foundWordDelete == "No Word") {
            DictionaryMangement.dictMange.changeScene(getClass().getResource("/DeleteButtonExtends2/deleteButtonExtends2.fxml"), event);
        }
        else {
            //System.out.println(DictionaryMangement.dictMange.SearchWord(wordDelete));
            Word w = DictionaryMangement.dictMange.SearchWord(wordDelete);
            Dictionary.dict.listWord.remove(Dictionary.dict.listWord.indexOf(w));
            DictionaryMangement.dictMange.changeScene(getClass().getResource("/DeleteButtonExtends/deleteButtonExtend.fxml"), event);
        }

    }

    /**
     * Ham hien len cua so them tu
     * @param event
     */
    public void AddWord(ActionEvent event) {
        String wordTarget = textFieldWord.getText();
        String wordExplain = textFieldExlain.getText();
        String foundWord = DictionaryMangement.dictMange.foundWord(Dictionary.dict.listWord, wordTarget);
        if(foundWord == "No Word")
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

    /**
     * Ham hien len cua so tra tu
     */
    public void searchButton() {
        String text = textFieldExtra.getText();
        String foundWord = DictionaryMangement.dictMange.listHasWord(Dictionary.dict.listWord, text);

        if(foundWord == "No Word") {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Search Button");
            alert.setHeaderText(null);
            alert.setContentText("Từ bạn muốn tìm kiếm không có trong từ điển mời bạn tra từ khác");
            alert.showAndWait();
            wordFoundExtra.setText("Bạn hãy tra từ khác");
        } else {
            wordFoundExtra.setText((DictionaryMangement.dictMange.foundWord(Dictionary.dict.listWord, foundWord)));
        }
    }

    /**
     * Ham hien len cua so sua tu
     */
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
}
