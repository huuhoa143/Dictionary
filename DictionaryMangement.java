import java.io.*;
import java.util.Scanner;

public class DictionaryMangement {
    public static DictionaryMangement dictMange = new DictionaryMangement();
    public int index = 0;
    public void insertFromCommandLine() {
        Scanner ip = new Scanner(System.in);
        String ipEnglish = ip.nextLine();
        String ipExplain = ip.nextLine();
        //System.out.print(ipEnglish);

        Dictionary.dict.listWord.add(new Word(ipEnglish, ipExplain));
    }

    public static void insetFromFile() throws IOException{
        File fileName = new File("dictionaries.txt");
        Scanner input = new Scanner(fileName);

        while(input.hasNext()) {
            String ipEnglish = input.next();
            String ipExplain = input.next();
            Dictionary.dict.listWord.add(new Word(ipEnglish, ipExplain));

        }
    }

}