/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.server;


import chat.controler.ControlerServer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DusanT
 */
public class ServerChatClient implements Runnable{
    
    private String username;
    private Socket soketZaKomunikaciju;
    public static BufferedReader IN;
    public static PrintStream OUT;
    
    
    public ServerChatClient(Socket soketZaKomunikaciju) {
        this.soketZaKomunikaciju = soketZaKomunikaciju;
    }

    @Override
    public void run() {
        System.out.println("Klijent nit aktivna");
        startChat();
    }

    private void startChat() {
        try {
            IN = new BufferedReader(
                    new InputStreamReader(
                            soketZaKomunikaciju.getInputStream()));
            
            OUT = new PrintStream(
                                        soketZaKomunikaciju.getOutputStream());
            
            
            
            String poruka = "";
            
            while(true){
                poruka = IN.readLine();
                if(poruka.startsWith("hello")){
                   // OUT.println("Welcome!!!");
                }else{
                    
                    ControlerServer.osluskivac(poruka, ServerChatClient.this);
                    
                    System.out.println(poruka);
                    //OUT.println("Your message is: "+ poruka);
                    
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerChatClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServerChatClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
