import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

//class creation of Application
public class Application {

    //contains main method, which uses DuplicateRemover class by calling the remove and write methods within it
    public static void main (String[] args) throws IOException {
        //File myFile = new File("C:\\Users\\Max & Chanelle\\IdeaProjects\\Gomer_p1_A4\\resources\\problem1.txt");
        DuplicateRemover duplicateRemover = new DuplicateRemover();

        //call remove method from DuplicateRemover while importing problem1.txt
        duplicateRemover.remove("problem1.txt");

        //call write method from DuplicateRemover while importing unique_words.txt (should write into empty text file)
        duplicateRemover.write("unique_words.txt");
    }


    //input file must be named "problem1.txt" and output file must be named "unique_words.txt"

}
