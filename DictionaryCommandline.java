import java.io.IOException;

public class DictionaryCommandline {

    public static DictionaryCommandline dictCommand = new DictionaryCommandline();
    public void showAllWord() {
        System.out.println("No  |English        |Vietnames");
        Dictionary.dict.listWord.forEach(word -> word.print());
        
    }

    public static  void DictionaryBasic() throws IOException{
        //DictionaryMangement.dictMange.insertFromCommandLine();
        DictionaryMangement.dictMange.insetFromFile();
        DictionaryCommandline.dictCommand.showAllWord();
    }
}