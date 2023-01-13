package com.example.ui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
  public static void main(String[] args) {

    new Thread( () -> {
      try {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started at " + new Date() + '\n');

        // Listen for a connection request
        Socket socket = serverSocket.accept();
  
        // Create data input and output streams
        DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
        DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
  
        while (true) {
          // Receive number from the client
          int number = inputFromClient.readInt();
  
          // Compute area
          BigInteger bigInteger = BigInteger.valueOf(number);
          boolean isPrime = bigInteger.isProbablePrime((int) Math.log(number));

          // Send area back to the client
          outputToClient.writeBoolean(isPrime);

          System.out.println("Number: " + number);
          System.out.println("Number is Prime: " + isPrime);
        }
      }
      catch(IOException ex) {
        ex.printStackTrace();
      }
    }).start();
  }
}
