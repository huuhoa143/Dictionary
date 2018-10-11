package sample;

public class Word {
    private String word_target, word_explain;
    private String wordSound;

    public String getWord() {
        return word_target;
    }

    public String getExplain() {
        return word_explain;
    }

    public String getWordSound() {
        return wordSound;
    }

    public void setWordSound(String wordSound) {
        this.wordSound = wordSound;
    }


    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public Word(String word_target, String word_explain, String wordSound) {

        this.word_target = word_target;
        this.word_explain = word_explain;
        this.wordSound = wordSound;
    }

    public Word() {

    }

    public String toString() {
        return word_target + "\t" + word_explain;
    }
}
