public class Word {
    private String word_target, word_explain;

    public String getWord() {
        return word_target;
    }

    public String getExplain() {
        return word_explain;
    }

    public Word(String word_target, String word_explain) {

        this.word_target = word_target;
        this.word_explain = word_explain;
    }

    public Word() {

    }

    public void print() {
        System.out.printf("%-10d| %-20s| %s\n", DictionaryMangement.dictMange.index, word_target, word_explain);
        DictionaryMangement.dictMange.index += 1;
    }
}