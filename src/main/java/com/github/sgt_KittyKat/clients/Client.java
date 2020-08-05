package com.github.sgt_KittyKat.clients;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket client = new Socket("127.0.0.1", 8080)) {
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();
            PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
            writer.println(message);
            InputStreamReader inputStreamReader = new InputStreamReader(client.getInputStream());
            scanner = new Scanner(inputStreamReader);
            System.out.println("Server says: " + scanner.nextLine());
        }
    }
}
