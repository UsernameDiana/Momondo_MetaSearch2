package socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Date;
import java.util.Scanner;


public class Socket {

    static int port = 8080;
    static String ip = "localhost"; // probably add dummy port

    public static void main(String[] args) throws IOException {

        if (args.length == 2) {
            ip = args[0];
            port = Integer.parseInt(args[1]);
        }

        // add server socket
        ServerSocket ss = new ServerSocket();

        // binds server socket
        ss.bind(new InetSocketAddress(ip, port));
        System.out.println("Server started, listening to port " + port + ", bound to " + ip);
        // starts listening for incoming connections

        // accepts connections
        while (true) {
            java.net.Socket searchCon = ss.accept(); // blocking call    
            handleSearchCon(searchCon);
            System.out.println("new search connection ");

        }
    }

    private static void handleSearchCon(java.net.Socket searchCon) throws IOException {

        PrintWriter pw = new PrintWriter(searchCon.getOutputStream(), true);
//        pw.println(new Date().toString());

        Scanner scan = new Scanner(searchCon.getInputStream());

//        String message = "";
//        while (!message.equals("stop")) {
//            message = scan.nextLine();
//        }

        searchCon.close();
        pw.close();
    }
}
