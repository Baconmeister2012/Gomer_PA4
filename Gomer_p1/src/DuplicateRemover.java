import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;



//class creation of Duplicate Remover
public class DuplicateRemover {
    //Scanner scnr = new Scanner();   //need data type or something
    public ArrayList<String> uniqueWords = new ArrayList<String>();    //create a hash set, since the add function for a set does not
    public ArrayList<String> inputWords = new ArrayList<String>();
    int numWords = 0, finalNumWords = 0;                                        //add duplicate entries (very useful here)

    //instance method remove, dataFile as parameter (dataFile is a path to a text file
    //remove must use a set of strings to eliminate duplicate words from dataFile
    public void remove(String dataFile) throws FileNotFoundException {
        FileInputStream inStream = null;
        Scanner inFS = null;
        String word1, word2;
        uniqueWords = new ArrayList<>();
        int i = 0, j;

        //System.out.printf("Made it inside remove method!\n");

        inStream = new FileInputStream(dataFile); //probably wrong, figure out how to properly pass the file as
                                                           //an argument
        inFS = new Scanner(inStream);   //create a scanner thing that takes in items from the inStream

        //System.out.println("Reading words from list (hopefully)");

        while (inFS.hasNext()) {    //while there is another word to be read, continue
            //word1 = inFS.next(); //assign the next word in the list to a workspace word

            //System.out.printf("Looking at adding %s to the list\n", word1);
            inputWords.add(inFS.next());
            i++;
        }
        numWords = inputWords.size();


        //check for duplicates
        for (i = 0; i < inputWords.size(); i++) {
            word1 = inputWords.get(i);

            for (j = 0; j < inputWords.size(); j++) {
                word2 = inputWords.get(j);

                if (i != j && (word1.equals(word2))) {   //if words are the same, remove second word
                    inputWords.remove(j);
                }
            }
        }

        //recount the number of words in the input array after deleting duplicates
        for (i = 0; i < inputWords.size(); i++) {
            if (inputWords.get(i) != null) {
                finalNumWords++;
            }
        }

        //write final list of input words to unique words list
        for (i = 0; i < finalNumWords; i++) {
            if (inputWords.get(i) != null) {
                uniqueWords.add(inputWords.get(i));
            }
        }

        for (i = 0; i < finalNumWords; i++) {
            //System.out.printf("Element %d of inputWords is: %s\n", i, inputWords.get(i));
        }


        inFS.close();   //close the input scanner stream thing
    }

    //unique words, or words that do not have duplicates, should be stored in an instance variable
    //called uniqueWords


    //instance method "write" that takes in parameter "outputFile" (outputFile is the path to a text file)
    //and writes the words in uniqueWords to the filed pointed to by outputFile
    //if the output file already exists, then it should be overwritten
    //if the output file does not exists, then it should be created
    public void write(String outputFile) throws IOException {
        File file = new File(outputFile);
        FileWriter writer = null;
        String word;
        int i;

        //if the file exists, continue
        if (file.exists()) {

            writer = new FileWriter(file, false);   //open output stream and have second argument set to false
                                                            //to enable overwriting
            //Iterator itr = uniqueWords.iterator();

            //while (itr.hasNext()) {
            //    String str = (String) itr.next();
            //    writer.write(str + "\n");
            //}

            //loop through each word in the unique list and write it to output
            for (i = 0; i < finalNumWords; i++) {
                writer.write(uniqueWords.get(i) + "\n");
            }

            //close input stream
            writer.close();

        //if the file does not exist, create one and continue
        } else {
            file.createNewFile();
            writer = new FileWriter(file);  //open output stream

            for (i = 0; i < uniqueWords.size(); i++) {
                word = uniqueWords.get(i);
                writer.write(word + "\n");
            }

            //close input stream
            writer.close();
        }
    }
}
