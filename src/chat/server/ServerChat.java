/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DusanT
 */
public class ServerChat implements Runnable{
    
    private Socket soketZaKomunikaciju;

    public ServerChat(Socket soketZaKomunikaciju) {
        this.soketZaKomunikaciju = soketZaKomunikaciju;
    }

    @Override
    public void run() {
        startChat();
    }

    private void startChat() {
        try {
            BufferedReader IN = new BufferedReader(
                    new InputStreamReader(
                            soketZaKomunikaciju.getInputStream()));
            
            PrintStream OUT = new PrintStream(
                                        soketZaKomunikaciju.getOutputStream());
            
            String poruka = "";
            while(true){
                poruka = IN.readLine();
                if(poruka.startsWith("hello")){
                    OUT.println("Welcome!!!");
                }else{
                    System.out.println(poruka);
                    OUT.println("Your message is: "+ poruka);
                    
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
