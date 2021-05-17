import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public static void main(String[] args) throws FileNotFoundException {

        String filename = "input.txt";
        File fileInput = new File(filename);
        if (!fileInput.exists()) {
            System.out.println("File is not found.");
            System.exit(1);
        }

        Scanner inputFile = new Scanner(fileInput);
        while (inputFile.hasNextLine()) {
            String name = inputFile.next();
            int id = inputFile.nextInt();
            String dept = inputFile.next();
            System.out.printf("Student Name: %10s, ID: %d, Department: %s\n", name, id, dept);
        }
        inputFile.close();
    }
}
