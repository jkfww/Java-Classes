import java.io.*;
import java.net.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        Socket clientSocket;

        int port = 6666;
        try {

            serverSocket = new ServerSocket(port);

        } catch (IOException e) {
            System.out.println("Could not listen to on port: " + port);
            System.exit(-1);
        }

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        System.out.println("Serwer gotowy, oczekiwanie na klientow");

        while(true) {
            try {

                clientSocket = serverSocket.accept();
                System.out.println("Zaakceptowano polaczenie");

                ClientThread client = new ClientThread(clientSocket);

                executor.execute(client);

                System.out.println("Uruchomiono klienta");

            } catch (IOException e) {
                System.out.println("Accept failed: " + port);
                System.exit(-1);
            }
        }
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

