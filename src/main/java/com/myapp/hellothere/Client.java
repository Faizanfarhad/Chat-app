package com.myapp.hellothere;

import javafx.application.Platform;
import javafx.scene.control.ListView;

import java.io.*;
import java.net.Socket;


public class Client{

        private Socket client;
        private PrintWriter out;
        private BufferedReader in;
        private boolean done;
        private ListView<String> ChatView;

        public Client(ListView<String> ChatView){
            this.ChatView = ChatView;
        }

        public void connect(){
            try {
                client = new Socket("127.0.0.1", 8081);
                out = new PrintWriter(client.getOutputStream(),true);
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));


                Thread recieveThread = new Thread( () ->{
                    try{

                String inMessage;
                while((inMessage = in.readLine()) != null ){
                    final  String message = inMessage;
                    Platform.runLater( () ->{
                        ChatView.getItems().add(message);
                    });
                }
                    }catch (IOException e){
                        System.out.println("connecting error : " + e.getMessage());
                        shutdown();
                    }
                });
                recieveThread.setDaemon(true);
                recieveThread.start();
            }catch (IOException e){
                System.out.println("Error While connecting !");
                shutdown();
            }
        }
        public void shutdown(){
            done = true;

            try{
                if(in!= null) in.close();
                if(out != null) out.close();
                if (!client.isClosed() && client != null){
                    client.close();
                }
            }catch (IOException e){
                e.getCause();
            }
        }

        public  void sendMessage(String message){
            if (out != null){
                out.println(message);
            }
        }



    class  InputHandler implements Runnable{
            @Override
            public void run() {
                try{
                    BufferedReader inReader =new BufferedReader(new InputStreamReader(System.in));
                    while (!done) {
                        String message = inReader.readLine();
                        if (message.equals("/quit")){
                            out.println(message);
                        inReader.close();
                        shutdown();

                    }else{
                        out.println(message);
                        }
                    }
                }catch(IOException e){
                    shutdown();
                }
            }
        }
}
