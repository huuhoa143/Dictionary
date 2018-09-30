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
<<<<<<< HEAD
        System.out.printf("%-10d| %-20s| %s\n", DictionaryMangement.dictMange.index, word_target, word_explain);
=======
        System.out.println(DictionaryMangement.dictMange.index + "\t|" + word_target + "\t|" + word_explain);
>>>>>>> 0488f608e0d102f405a4fad7515ee63d48eda104
        DictionaryMangement.dictMange.index += 1;
    }
}