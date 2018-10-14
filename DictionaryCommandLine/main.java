import java.io.*;

public class main {
    public static void main(String[] args) throws IOException {
        DictionaryCommandline.insertFromFile();
        DictionaryCommandline.DictionaryBasic();
        // DictionaryCommandline.dictionaryAdvanced();
        DictionaryCommandline.dictionarySeacher();
        DictionaryCommandline.dictionaryRemove();
        System.out.println("Danh sach sau khi xoa: ");
        DictionaryCommandline.DictionaryBasic();
    }
}