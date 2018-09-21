public class DictionaryCommandline {

    public static DictionaryCommandline dictCommand = new DictionaryCommandline();
    public void showAllWord() {
        
        Dictionary.dict.listWord.forEach(word -> word.print());
        
    }

    public static  void DictionaryBasic() {
        DictionaryMangement.dictMange.insertFromCommandLine();
        DictionaryCommandline.dictCommand.showAllWord();
    }
}