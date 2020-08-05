package com.github.sgt_KittyKat.servers.echoServer;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                try (Socket client = serverSocket.accept()) {
                    InputStreamReader reader = new InputStreamReader(client.getInputStream());
                    Scanner scanner = new Scanner(reader);
                    PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                    writer.println(scanner.nextLine());
                }
            }
        }
    }
}
