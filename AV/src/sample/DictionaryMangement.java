package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class DictionaryMangement {
    public static DictionaryMangement dictMange = new DictionaryMangement();
    /*
    public static void insertFromFile(){
        try {
            File fileName = new File("dictionaries.txt");
            Scanner input = new Scanner(fileName);
            while (input.hasNextLine()) {
                String word1 = input.next();
                String word2 = input.nextLine();
                Dictionary.dict.listWord.add(new Word(word1, word2.trim()));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }*/
    public static boolean getFilterOutput(ArrayList<Word> words, String filter) {
        for (Word tu : words) {
            if(tu.getWord().contains(filter)) {
                return true;
            }
        }
        return false;
    }

    public static String dictionaryLockup(String a) {

        //Scanner input = new Scanner(System.in);
        //System.out.println("Nhap tu ban muon tra cuu: ");
        //String wordLookup = input.next();
        //System.out.println(getFilterOutput(Dictionary.dict.listWord, a).getExplain());
        if(getFilterOutput(Dictionary.dict.listWord, a)) {
            return DictionaryMangement.dictMange.foundWord(Dictionary.dict.listWord, a);
        }
        return "No Word";
    }

    public ArrayList<String> arrayWordTarget(ArrayList<Word> words, String tra) {
        ArrayList<String> arr = new ArrayList<>();
        for(Word w : words){
            if(w.getWord().startsWith(tra)) {
                arr.add(w.getWord());
            }
        }
        return arr;
    }

    public ArrayList<String> arrayAfterAdd(ArrayList<Word> words) {
        ArrayList<String> arr = new ArrayList<>();
        words.forEach(word -> arr.add(word.getWord()));
        return arr;
    }

    public List<String> getWordOutput(ArrayList<Word> words, String tra) {
        List<String> foundWord = new ArrayList<>();
        for (Word tu : words) {
            if (tu.getWord().startsWith(tra)) {
                foundWord.add(tu.getWord());
            }
        }

        return foundWord;
    }

    /**
     * Hàm trả về nghĩa của từ cần tìm
     * @param words
     * @param tra
     * @return Nghĩa của từ cần tìm
     */
    public String foundWord(ArrayList<Word> words, String tra) {
        for(Word a: words) {
            if(a.getWord().equals(tra)) {
                return a.getExplain();
            }
        }
        return "No Word";
    }
    public Boolean listHasWord(ArrayList<Word> words, String wordTra) {
        for(Word w : words) {
            if(w.getWord().equals(wordTra)) {
                return true;
            }
        }
        return false;
    }
    public String foundSound(ArrayList<Word> words, String tra) {
        for(Word a: words) {
            if(a.getWord().equals(tra)) {
                return a.getWordSound();
            }
        }
        return "No Word";
    }
    public void dictionaryExportToFile(ArrayList<Word> words, String path) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for(Word word : words) {
                printWriter.println(word.toString());
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Hàm mở ra 1 cửa sổ
     * @param loc Địa chỉ
     * @param title Tiêu đề
     * @param parentStage Stage
     */
    public void loadWindow(URL loc, String title, Stage parentStage) {
        try {
            Parent parent = FXMLLoader.load(loc);
            Stage stage = null;
            if(parentStage != null) {
                stage = parentStage;
            } else {
                stage = new Stage(StageStyle.DECORATED);
            }
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    /**
     * Hàm nhập dữ liệu từ file
     */
    public void insertFromFiletest() {
        try {
            String content= dictMange.readFile("anhviet109K.dict", Charset.defaultCharset());
            String[] words = content.split("@");
            for (String word: words) {
                String result[] = word.split("\r?\n", 2);
                if (result.length >1) {
                    String wordExplain1 = new String();
                    String wordTarget1 = new String();
                    String wordSound1 = new String();
                    if(result[0].contains("/")) {
                        String firstmeaning = result[0].substring(0, result[0].indexOf("/"));
                        String lastSoundMeaning = result[0].substring(result[0].indexOf("/"), result[0].length());
                        wordTarget1 = firstmeaning;
                        wordSound1 = lastSoundMeaning;
                    }
                    else
                    {
                        wordTarget1 = result[0];
                        wordSound1 = "";
                    }
                    wordExplain1 = result[1];
                    Dictionary.dict.listWord.add( new Word(wordTarget1, wordExplain1, wordSound1));
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
    public String readFile(String path, Charset encoding) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    /**
     * Hàm thêm từ
     * @param wordTarget1 từ Tiếng Anh
     * @param wordExplain1 từ Tiếng Việt
     * @return Trả về 1 dãy Word sau khi thêm từ
     */
    public ArrayList<Word> AddWord(String wordTarget1, String wordExplain1) {
        Dictionary.dict.listWord.add(new Word(wordTarget1, wordExplain1, ""));
        return  Dictionary.dict.listWord;
    }

    /**
     * Hàm chuyển cảnh
     * @param url Địa chỉ
     * @param event Sự kiện
     */
    public void changeScene(URL url, ActionEvent event) {
        try {
            Parent searchParent = FXMLLoader.load(url);
            Scene searchScene = new Scene(searchParent);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

            window.setScene(searchScene);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public ArrayList<Word> deleteWord(String word) {
        ArrayList<Word> arr = new ArrayList<Word>();
        String soundWord = DictionaryMangement.dictMange.foundSound(Dictionary.dict.listWord, word);
        String wordExplain = DictionaryMangement.dictMange.foundWord(Dictionary.dict.listWord, word);
        for(Word w : Dictionary.dict.listWord) {
            if(!(w.equals(new Word(word, wordExplain, soundWord)))) {
                arr.add(w);
            }
        }
        Dictionary.dict.listWord = arr;
        return Dictionary.dict.listWord;
    }
    public void EditWord(ArrayList<Word>words, String word, String explain) {
        for(Word w : words) {
            if(w.getWord().equals(word)) {
                w.setWord_explain(explain);
            }
        }
        Dictionary.dict.listWord = words;
    }
    public String foundWordabc(ArrayList<Word> words, String tra) {
        Word w = new Word(tra, DictionaryMangement.dictMange.foundWord(Dictionary.dict.listWord, tra), DictionaryMangement.dictMange.foundSound(Dictionary.dict.listWord, tra));
        if(words.contains(w)) {
            return w.getWord();
        }
        return "No Word";
    }

    /**
     * Hàm phục vụ cho chức năng My Word
     * @param words Mảng gồm nhiều từ
     * @return Trả về 1 dãy các từ tiếng anh
     */
    public ArrayList<String> listWordTarget(ArrayList<Word> words) {
        ArrayList<String> arr = new ArrayList<String>();
        for(Word w: words) {
            arr.add(w.getWord());
        }
        return arr;
    }
}
