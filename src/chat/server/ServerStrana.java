/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DusanT
 */
public class ServerStrana {
    
    public static final int PORT = 5555;

    public ServerStrana() {
    }
    
    public static void main(String[] args) {
        try {
            ServerStrana server = new ServerStrana();
            server.startServer();
        } catch (IOException ex) {
            Logger.getLogger(ServerStrana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void startServer() throws IOException{
        ServerSocket soket = new ServerSocket(PORT);
        
        while(true){
            Socket client = soket.accept();
            //ServerChat newClient = new ServerChat(client);
            Thread newThread = new Thread(new ServerChat(client));
            newThread.start();
        }
    }
}
