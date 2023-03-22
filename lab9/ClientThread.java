import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread implements Runnable {

    Socket socket;

    ClientThread(Socket socket)
    {
        this.socket = socket;
    }

    public void run()
    {

                PrintWriter out;
                BufferedReader in;

                try {
                    out = new PrintWriter(socket.getOutputStream(), true);
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String inputLine;

                    while ((inputLine = in.readLine()) != null) {
                        double result = Server.count(inputLine);
                        out.println(result);
                    }

                    out.close();
                    in.close();
                    socket.close();

                } catch(IOException e)
                {
                    e.printStackTrace();
                }
    }

}

