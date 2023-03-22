import java.io.FileNotFoundException;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException {

        if (args.length < 4) {
            System.out.println("""
                    Too less arguments.
                    1 - path to input file
                    2 - path to output file
                    3 - instruction (crypt/decrypt)
                    4 - algorithm to use (rot/Polibiusz)
                    """);
            return;
        }

        String path_to_file_in = args[0];
        String path_to_file_out = args[1];
        String algorithm = args[3];
        boolean crypt;
        if (args[2].equals("crypt")) {
            crypt = true;
        } else if (args[2].equals("decrypt")) {
            crypt = false;
        } else {
            System.out.println("Undefinied instructions. Use crypt or decrypt");
            return;
        }

        Cryptographer cryptographer = new Cryptographer();

        if (algorithm.equals("rot")) {
            if (crypt) {
                cryptographer.cryptfile(path_to_file_in, path_to_file_out, new ROT11());
            } else {
                cryptographer.decryptfile(path_to_file_in, path_to_file_out, new ROT11());
            }
        } else if (algorithm.equals("Polibiusz")) {
            if (crypt) {
                cryptographer.cryptfile(path_to_file_in, path_to_file_out, new Polibiusz());
            } else {
                cryptographer.decryptfile(path_to_file_in, path_to_file_out, new Polibiusz());
            }
        } else {
            System.out.println("Undefinied algorithm. Use Polibiusz or rot");
            return;
        }
    }

}











