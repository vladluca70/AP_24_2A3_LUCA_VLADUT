package org.example;

import java.io.*;
import java.net.*;

public class GameClient {
    private Socket socket;
    private BufferedReader userInput;

    public GameClient(String serverAddress, int serverPort)
    {
        try {
            socket = new Socket(serverAddress, serverPort);
            userInput = new BufferedReader(new InputStreamReader(System.in));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void start() {
        try
        {
            if(socket!=null) {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                String command;
                while (!(command = userInput.readLine()).equals("exit")) {
                    out.println(command);
                }
                socket.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        String serverAddress = "127.0.0.1";
        int serverPort = 1234;
        GameClient client = new GameClient(serverAddress, serverPort);
        client.start();
    }
}