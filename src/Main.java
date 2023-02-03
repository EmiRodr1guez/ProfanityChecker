import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class Main {

    //Simple webscraper using jsoup
    public static List<String> scrapeWords() throws IOException {
        List<String> words = new ArrayList<>();
        Document document = Jsoup.connect("https://www.cs.cmu.edu/~biglou/resources/bad-words.txt").get();
        Element body = document.body();
        String[] lineWords = body.text().split("\\s+");
        for (String word : lineWords) {
            words.add(word);
        }
        return words;
    }

    //Takes user input. Using scrape words will check if it is a bad words.
    public static void main(String[] args) throws IOException {
        scrapeWords();

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter a word!");

        String userInput = myObj.nextLine().toLowerCase();
        boolean isBadWord = false;
        for (String word : scrapeWords()) {
            if (word.equals(userInput)) {
                isBadWord = true;
                break;
            }
        }

        //Checks user input. Bad words in Database will return Bad Boy.

        if (isBadWord) {
            System.out.println("Bad boy!");
        } else {
            System.out.println("Good boy!");
        }


    }

}
