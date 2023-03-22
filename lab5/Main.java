import java.io.FileNotFoundException;

public class Main {
    //java Main gravity.txt gravity-delayed.txt 100 25
    public static void main(String[] args){
        if (args.length != 4) {
            System.out.println("""
                    Incorrect number of arguments.
                    1 - path to input file
                    2 - path to output file
                    3 - delay value
                    4 - frame rate
                    example: gravity.txt gravity-delayed.txt 100 25""");
            return;
        }

        String pathToFileIn = args[0];
        String pathToFileOut = args[1];
        int delay = Integer.parseInt(args[2]);
        int frameRate = Integer.parseInt(args[3]);

        Delayer delayer = new Delayer();

        try
        {
            delayer.delay(pathToFileIn, pathToFileOut, delay, frameRate);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
            return;
        }
        catch (IncorrectFormatException e) {
            System.out.println("IncorrectFormatException catched: ");
            e.printMessage();
            return;
        }
        catch (IncorrectTimeIntervalException e) {
            System.out.println("IncorrectTimeIntervalException catched: ");
            e.printMessage();
            return;
        }
        catch(Exception e)
        {
            System.out.println("Unknown exception catched: ");
            e.printStackTrace();
            return;
        }

        System.out.println("Finished succesfully");
    }
}