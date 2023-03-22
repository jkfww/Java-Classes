import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Cryptographer
{
    public void cryptfile(String path_to_file_in, String path_to_file_out, Algorithm algorithm) throws FileNotFoundException {

        File inputFile = new File (path_to_file_in);
        Scanner scanner = new Scanner(inputFile);
        StringBuilder inputText = new StringBuilder();
        String outputText;

        while(scanner.hasNextLine())
        {
            inputText.append(scanner.nextLine());
            inputText.append("\n");
        }

        if(inputText.length()>0) inputText.deleteCharAt(inputText.length()-1);

        outputText = algorithm.crypt(inputText.toString());


        File outputFile = new File(path_to_file_out);
        PrintWriter writer = new PrintWriter(outputFile);

        writer.print(outputText);

        writer.close();

    }

    public void decryptfile(String path_to_file_in, String path_to_file_out, Algorithm algorithm) throws FileNotFoundException
    {

        File inputFile = new File (path_to_file_in);
        Scanner scanner = new Scanner(inputFile);
        StringBuilder inputText = new StringBuilder();
        String outputText;

        while(scanner.hasNextLine())
        {
            inputText.append(scanner.nextLine());
            inputText.append("\n");
        }
        if(inputText.length()>0) inputText.deleteCharAt(inputText.length()-1);

        outputText = algorithm.decrypt(inputText.toString());

        File outputFile = new File(path_to_file_out);
        PrintWriter writer = new PrintWriter(outputFile);

        writer.print(outputText);

        writer.close();


    }
}
