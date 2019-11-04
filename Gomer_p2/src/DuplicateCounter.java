import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Scanner;


public class DuplicateCounter {
    private HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();  //counter is (word, count)
    private HashMap<Integer, String> inputWords = new HashMap<Integer, String>();   //is (wordNumber, word)
    private ArrayList<String> words = new ArrayList<String>();
    String key;

    public void count(String dataFile) throws FileNotFoundException {
        FileInputStream inStream = null;
        Scanner inFS = null;
        String word1, word2;
        Boolean foundDuplicateWord = false;
        int i = 0, j;

        inStream = new FileInputStream(dataFile);

        inFS = new Scanner(inStream);

        while (inFS.hasNext()) {    //while there is another word in the input file to be read
            //assign words from input file to HashMap called inputWords

            inputWords.put(i, inFS.next()); //for each key starting with 0, assign the next word in the text file
            //to the hash map and increment i
            i++;
        }

        //confirm input into hashmap was successful
       // System.out.printf("First step, stored input words are: \n");
        for (i = 0; i < inputWords.size(); i++) {
            //System.out.printf("Word %d is: %s\n", i + 1, inputWords.get(i));
        }

        //perform comparisons and increment counts of each word
        for (i = 0; i < inputWords.size(); i++) {
            word1 = inputWords.get(i);  //assign first comparison word to the next word to be counted
            wordCounter.putIfAbsent(word1, 0);  //assign next unique word into counter hashmap, put 1 count

            for (j = i - 1; j >= 0; j--) {
                if ((word1.equals(inputWords.get(j)))) {   //if word1 doesn't equal any previous words in the list
                    foundDuplicateWord = true;
                    // System.out.printf("Word " + word1 + " has a count of: " + wordCounter.get(word1) + "\n");
                }
            }

            if (!foundDuplicateWord) {   //if word1 doesn't equal any previous words in the list
                for (j = 0; j < inputWords.size(); j++) {
                    word2 = inputWords.get(j);  //assign second comparison word to check for increments to first word count

                    if (word1.equals(word2)) {
                        wordCounter.put(word1, (wordCounter.get(word1) + 1));   //if word1 equals word2, look up word1 in
                        //wordCounter and add 1 to it's count value
                    }
                }
                //System.out.printf("Word " + word1 + " has a count of: " + wordCounter.get(word1) + "\n");
            }

            //for (j = 0; j < inputWords.size(); j++) {
            //    word2 = inputWords.get(j);  //assign second comparison word to check for increments to first word count

            //    if (word1.equals(word2)) {
            //       wordCounter.put(word1, (wordCounter.get(word1) + 1));   //if word1 equals word2, look up word1 in
            //wordCounter and add 1 to it's count value
            //}
        }


        //confirm count hashmap was successful
        //System.out.printf("WordCounter has after counting: \n");
        //for (i = 0; i < inputWords.size(); i++) {
        //    String key = inputWords.entry
        //    System.out.printf("%s has a count of: %d\n", , );
        //}
        j = 0;
        foundDuplicateWord = false;


        for (i = 0; i < inputWords.size(); i++) {
            word1 = inputWords.get(i);

            //check previous words in the list
            for (j = i - 1; j >= 0; j--) {
                if ((word1.equals(inputWords.get(j)))) {   //if word1 doesn't equal any previous words in the list
                    foundDuplicateWord = true;
                    // System.out.printf("Word " + word1 + " has a count of: " + wordCounter.get(word1) + "\n");
                }
            }

            if (!foundDuplicateWord) {   //if word1 doesn't equal any previous words in the list
                //System.out.printf("Word " + word1 + " has a count of: " + wordCounter.get(word1) + "\n");
            }
        }


        inFS.close();
    }

    public void write(String outputFile) throws IOException {
        File file = new File(outputFile);
        FileWriter writer = null;
        String word1, word2;
        Boolean foundDuplicateWord = false;
        int i = 0, j = 0;

        if (file.exists()) {

            writer = new FileWriter(file, false);

            for (i = 0; i < inputWords.size(); i++) {
                word1 = inputWords.get(i);

                //check previous words in the list
                for (j = i - 1; j >= 0; j--) {
                    if ((word1.equals(inputWords.get(j)))) {   //if word1 doesn't equal any previous words in the list
                        foundDuplicateWord = true;
                        // System.out.printf("Word " + word1 + " has a count of: " + wordCounter.get(word1) + "\n");
                    }
                }

                if (!foundDuplicateWord) {   //if word1 doesn't equal any previous words in the list
                    //writer.write("Word " + word1 + " has a count of: " + wordCounter.get(word1) + "\n");
                    //System.out.printf("Word " + word1 + " has a count of: " + wordCounter.get(word1) + "\n");
                }
            }

            writer.close();
        } else {
            file.createNewFile();
            writer = new FileWriter(file);  //open output stream

            for (i = 0; i < inputWords.size(); i++) {
                word1 = inputWords.get(i);

                //check previous words in the list
                for (j = i - 1; j >= 0; j--) {
                    if ((word1.equals(inputWords.get(j)))) {   //if word1 doesn't equal any previous words in the list
                        foundDuplicateWord = true;
                        // System.out.printf("Word " + word1 + " has a count of: " + wordCounter.get(word1) + "\n");
                    }
                }

                if (!foundDuplicateWord) {   //if word1 doesn't equal any previous words in the list
                    writer.write("Word " + word1 + " has a count of: " + wordCounter.get(word1) + "\n");
                    //System.out.printf("Word " + word1 + " has a count of: " + wordCounter.get(word1) + "\n");
                }
            }
            writer.close();
        }
    }
}
