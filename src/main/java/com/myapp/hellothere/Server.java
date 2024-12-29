package com.myapp.hellothere;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.System.exit;
import static java.lang.System.out;

public class Server implements Runnable {

    private ArrayList<ConnectionHandler> connections;
    private ServerSocket server;
    private boolean done;
    private ExecutorService pool;


    public Server(){
        connections = new ArrayList<>();
         done = false;
    }


    public void run() {
        try {
            server = new ServerSocket(8081);
            pool = Executors.newCachedThreadPool();
            while (!done) {
                Socket client = server.accept();
                ConnectionHandler handler = new ConnectionHandler(client);
                connections.add(handler);
                pool.execute(handler);
            }
            } catch(Exception e){
               //TODO : quit
        }
    }

        public void broadcast(String message){
        for (ConnectionHandler ch :  connections){
            if (ch != null){
            ch.sendMessage(message);
            }
        }
        }

        public  void shutdown(){
        try {

        done = true;
        if (!server.isClosed()){
            server.close();
        }
        }catch (IOException e){
            shutdown();
        }
        for (ConnectionHandler ch : connections){
            ch.shutdown();
        }
        }

    class ConnectionHandler implements Runnable{

        private Socket client;
        private  BufferedReader in;
        private PrintWriter out;
        String nickname;
        public ConnectionHandler(Socket client){
            this.client = client;
        }

        public void run()  {
            try {
                out = new PrintWriter(client.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out.println(" Enter a nickname : " );
                nickname = in.readLine();
                System.out.print(nickname  + "   Connected");
                broadcast(nickname + " joined the chat ");


                String message;
                while((message = in.readLine()) != null){
                if (message.startsWith("/changeNick")){
                    String[] messageSplit = message.split(" " , 2);
                    if (messageSplit.length == 2 ){
                        broadcast(nickname + "  rename themselves to " +  message);
                        System.out.println(nickname + "rename themselves to " + message);
                        nickname = messageSplit[1];
//                        out.println("SuccessFully Changed nickname to  : " + nickname );
                    }else {
                        out.println("No nickname provided ");
                    }
                } else if ((message.startsWith("/quit"))) {
                    broadcast(nickname + " left the chat ");
                    shutdown();
                } else  {
                    broadcast(nickname + " : " + message);
                }
                }

            }catch(IOException e){
               shutdown();
            }
        }
        public void sendMessage(String message){
            out.println(message);
        }
        public void shutdown(){

            try {
                pool.shutdown();
                in.close();
                out.close();
                if (!client.isClosed()) {
                client.close();
                }
            }catch (IOException e){
             shutdown();
            }
        }

    }
    public static  void  main(String[] args){
        Server server = new Server();
        server.run();
    }
}
