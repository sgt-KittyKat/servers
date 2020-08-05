package com.github.sgt_KittyKat.clients;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TimeClient {
    public static void main(String[] args) throws IOException {
    try (Socket client = new Socket("127.0.0.1", 8080)) {

        InputStreamReader inputStreamReader = new InputStreamReader(client.getInputStream());
        Scanner scanner = new Scanner(inputStreamReader);
        System.out.print("Server says: ");
        System.out.print(scanner.next() + ":");
        System.out.print(scanner.next() + ":");
        System.out.print(scanner.next());
    }
}
}
