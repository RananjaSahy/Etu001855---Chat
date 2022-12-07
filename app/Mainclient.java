package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import app.*;

public class Mainclient {

    public static void main(String[] args) {


        //Frameclient frame = new Frameclient("Sahy");

        try{

            //BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //     PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
             Scanner scanner = new Scanner(System.in);
             String userInput ="";
             String host="";
        //     String clientName = "empty";

        //     ClientRunnable clientRun = new ClientRunnable(socket);


        //     new Thread(clientRun).start();

                 System.out.println("Enter your name : ");
                    userInput = scanner.nextLine();
                    System.out.println("host :");
                    host = scanner.nextLine();
                    Frameclient frame = new Frameclient(userInput,host);
        //         clientName = userInput;
        //         output.println(userInput+" a rejoint la discussion");
                
        //     while (!userInput.equals("exit")) {
               
        //             String message = ( "(" + clientName + ")" + " : " );
        //             userInput = scanner.nextLine();
        //             output.println(message + " " + userInput);
        //             if (userInput.equals("exit")) {
        //                 break;
        //             }
        //    }
                      
        } catch (Exception e) {
            System.out.println("Exception occured in client main: " + e.getStackTrace());
    }

    
    }
}