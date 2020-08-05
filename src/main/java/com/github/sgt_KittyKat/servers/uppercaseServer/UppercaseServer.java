package com.github.sgt_KittyKat.servers.uppercaseServer;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class UppercaseServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                try (Socket client = serverSocket.accept()) {
                    InputStreamReader reader = new InputStreamReader(client.getInputStream());
                    Scanner scanner = new Scanner(reader);
                    String uppercaseMessage = scanner.nextLine();
                    PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                    writer.println(uppercaseMessage.toUpperCase());
                }
            }
        }
    }
}
