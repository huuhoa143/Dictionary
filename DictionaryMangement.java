import java.util.Scanner;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class DictionaryMangement {
    public static DictionaryMangement dictMange = new DictionaryMangement();
    public int index = 0;
    public void insertFromCommandLine() {
        Scanner ip = new Scanner(System.in);

        String ipEnglish = ip.nextLine();
        String ipExplain = ip.nextLine();

        Dictionary.dict.listWord.add(new Word(ipEnglish, ipExplain));
    }

    /*public void insetFromFile() {
        FileInputStream file = new FileInputStream("dictionaries.txt");
        DataInputStream dataFile = new DataInputStream(file);

    }*/

}