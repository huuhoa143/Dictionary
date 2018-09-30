import java.io.IOException;

public class DictionaryCommandline {

    public static DictionaryCommandline dictCommand = new DictionaryCommandline();

    public void showAllWord() {
        System.out.println("No        |English              |Vietnames");
        Dictionary.dict.listWord.forEach(word -> word.print());
        DictionaryMangement.dictMange.index = 0;
    }
    public static void insertFromFile() {
        DictionaryMangement.dictMange.insertFromFile();
    }
    public static void DictionaryBasic() {
        // DictionaryMangement.dictMange.insertFromCommandLine();
        //DictionaryMangement.dictMange.insertFromFile();
        DictionaryCommandline.dictCommand.showAllWord();
    }

    public static void dictionaryAdvanced() throws IOException {
        DictionaryMangement.dictMange.dictionaryLockup();
    }

    public static void dictionarySeacher() throws IOException {
        DictionaryMangement.dictMange.dictionaryFind();
    }

    public  static  void dictionaryRemove() throws IOException {
        DictionaryMangement.dictMange.removeWord();
    }
}