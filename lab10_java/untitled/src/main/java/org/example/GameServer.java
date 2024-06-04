package org.example;

import java.io.*;
import java.net.*;

public class GameServer {
    private ServerSocket serverSocket;

    public GameServer(int port)
    {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start()
    {
        while (true)
        {
            try
            {
                Socket socket = serverSocket.accept();
                if(socket!=null) {
                    System.out.println("Client adress " + socket.getInetAddress().getHostName());
                    ClientThread clientThread = new ClientThread(socket);
                    clientThread.start();
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)
    {
        int port = 1234;
        GameServer server = new GameServer(port);
        server.start();
    }
}

class ClientThread extends Thread
{
    private Socket socket;

    public ClientThread(Socket socket)
    {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String command;
            while ((command = in.readLine()) != null)
            {
                System.out.println("Server received the request: " + command);
                if (command.equals("stop"))
                {
                    out.println("Server stopped");
                    break;
                }
                out.println("Server received the request: " + command);
            }
            socket.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
