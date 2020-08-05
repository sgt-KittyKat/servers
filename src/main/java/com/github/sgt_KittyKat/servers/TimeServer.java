package com.github.sgt_KittyKat.servers;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.TimeZone;

public class TimeServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                try (Socket client = serverSocket.accept()) {
                    LocalDateTime now = LocalDateTime.now();
                    PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                    writer.println(now.getHour());
                    writer.println(now.getMinute());
                    writer.println(now.getSecond());
                }
            }
        }
    }
}
