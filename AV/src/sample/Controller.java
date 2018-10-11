package sample;

import com.jfoenix.controls.JFXButton;
import com.voicerss.tts.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
        alert.setContentText("Nguyễn Hữu Hoà");
        alert.showAndWait();
    }
}
