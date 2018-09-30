import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionaryMangement {
    public static DictionaryMangement dictMange = new DictionaryMangement();
    public int index = 0;

    public static void insertFromCommandLine() {
        Scanner ip = new Scanner(System.in);
        String ipEnglish = ip.nextLine();
        String ipExplain = ip.nextLine();
        Dictionary.dict.listWord.add(new Word(ipEnglish, ipExplain));

    }

    public static void insetFromFile(){
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
    }

    public static Word getFilterOutput(ArrayList<Word> words, String filter) {
        Word indexx = new Word();
        for (Word tu : words) {
            if (tu.getWord().equals(filter)) {
                indexx = tu;
            }
        }
        return indexx;
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

    public static void dictionaryLockup() {

        Scanner input = new Scanner(System.in);
        System.out.println("Nhap tu ban muon tra cuu: ");
        String wordLookup = input.next();
        System.out.println(getFilterOutput(Dictionary.dict.listWord, wordLookup).getExplain());
    }

    public void dictionaryFind() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap tu ban muon tim kiem: ");
        String wordFind = input.next();
        for (String word : getWordOutput(Dictionary.dict.listWord, wordFind)) {
            System.out.println(word);
        }

    }
    public  void dictionaryExportToFile() {
        
    }

}