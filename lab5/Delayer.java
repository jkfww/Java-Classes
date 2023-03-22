import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Delayer {

    boolean checkNumber(String part)
    {

        if (part.indexOf('{')!=0)  return false;
        int i;
        for(i=1; i<part.indexOf('}'); i++)
        {
            if(!Character.isDigit(part.charAt(i))) return false;
        }

        if(part.indexOf('{', i)!=i+1) return false;

        i+=2;
        for(; i<part.indexOf('}', i); i++)
        {
            if(!Character.isDigit(part.charAt(i))) return false;
        }
        return true;
    }

    void delay(String in, String out, int delay, int fps) throws Exception {

        //opening files
        String filename = in.substring(in.lastIndexOf("/")+1);
        File inputFile = new File (in);
        Scanner scanner = new Scanner(inputFile);
        File outputFile = new File(out);
        PrintWriter writer = new PrintWriter(outputFile);
        int lineCounter = 0;
        int start;
        int end;
        String text;


        while(scanner.hasNext())
        {
            String line = scanner.nextLine();
            lineCounter++;
            if(line.isEmpty())
            {
                continue;
            }

            String part = line.substring(0, line.indexOf('}', line.indexOf('}')+1)+1);

            if(!checkNumber(part)) {
                scanner.close();
                writer.close();
                throw new IncorrectFormatException("In file " + filename + " in line " + lineCounter  + "\n" + line  + " \nAccepted format: {1234}{4567}");
            }

            text = line.substring(line.lastIndexOf("}") + 1);
            start = Integer.parseInt(part.substring(1, part.indexOf("}")));
            end = Integer.parseInt(part.substring(part.lastIndexOf("{")+1, part.length()-1));


           if(start>end) {
               scanner.close();
               writer.close();
               throw new IncorrectTimeIntervalException("In file " + filename + " in line " + lineCounter +  "\n" + line + " \nStart value is bigger than end");
           }

            //add delay
            start+=delay/fps;
            end+=delay/fps;

            String finalText = "{"+start+"}{"+end+"}"+text;
            writer.println(finalText);

        }

        scanner.close();
        writer.close();
    }
}

