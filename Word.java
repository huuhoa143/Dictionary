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
        System.out.println(DictionaryMangement.dictMange.index + "\t|" + word_target + "\t|" + word_explain);
        DictionaryMangement.dictMange.index += 1;
    }
}