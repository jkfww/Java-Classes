import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        int port = 6666;
        try {

            serverSocket = new ServerSocket(port);

        } catch (IOException e) {
            System.out.println("Could not listen to on port: " + port);
            System.exit(-1);
        }

            try {

                clientSocket = serverSocket.accept();
                System.out.println("Zaakceptowano polaczenie");


            } catch (IOException e) {
                System.out.println("Accept failed: " + port);
                System.exit(-1);
            }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            double result = count(inputLine);
            out.println(result);
        }

        System.out.println("Zakonczono prace z klientem");

        //close
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();

    }


        public static double count (String inputLine)
        {
            double result = 0;

            if (inputLine.contains("+")) {
                String part1 = inputLine.substring(0, inputLine.indexOf("+"));
                String part2 = inputLine.substring(inputLine.indexOf("+") + 1);
                result = Double.parseDouble(part1) + Double.parseDouble(part2);
            } else if (inputLine.contains("-")) {
                String part1 = inputLine.substring(0, inputLine.indexOf("-"));
                String part2 = inputLine.substring(inputLine.indexOf("-") + 1);
                result = Double.parseDouble(part1) - Double.parseDouble(part2);
            } else if (inputLine.contains("*")) {
                String part1 = inputLine.substring(0, inputLine.indexOf("*"));
                String part2 = inputLine.substring(inputLine.indexOf("*") + 1);
                result = Double.parseDouble(part1) * Double.parseDouble(part2);
            } else if (inputLine.contains("/")) {
                String part1 = inputLine.substring(0, inputLine.indexOf("/"));
                String part2 = inputLine.substring(inputLine.indexOf("/") + 1);
                result = Double.parseDouble(part1) / Double.parseDouble(part2);
            }

            return result;

        }




}

