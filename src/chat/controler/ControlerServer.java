/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.controler;

import chat.server.ServerChatClient;
import chat.server.ServerStrana;
import dao.DaoIstorijaAktivnosti;
import dao.DaoNalog;
import dao.impl.DaoIstorijaAktivnostiImpl;
import dao.impl.DaoNalogImpl;
import domen.Nalog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import javafx.util.converter.LocalDateTimeStringConverter;
import util.Pol;
import util.TipAktivnosti;

/**
 *
 * @author DusanT
 */
public class ControlerServer {
    
    public static void registracija(ServerChatClient client) throws IOException, FileNotFoundException, SQLException{
        String log = ServerChatClient.IN.readLine();
        String[] niz = log.split(":");//(ime, prezime, datRodjenja, pol, drzava, username, password)               
        
        
        // pretvaranje elmenta datum iz niza u niz integera da bismo mogli da kreiramo datum rodjenja novog korisnika
        int[] datum = Arrays.asList(niz[2].split("\\.")).stream().mapToInt(Integer::parseInt).toArray();
        Calendar cal = Calendar.getInstance();
        cal.set(datum[2], datum[1]-1, datum[0]);
        Nalog novi = new Nalog(niz[0], niz[1], cal.getTime(), Pol.valueOf(niz[3]), niz[4], null, null, niz[5], niz[6]);
        
        if(uporediNalogSaBazom(novi)){
            ServerChatClient.OUT.println("bad");
        }else{
            DaoIstorijaAktivnosti dia = new DaoIstorijaAktivnostiImpl();
            DaoNalog dn = new DaoNalogImpl();
            
            dia.kreirajTabeluAktivnosti(niz[5]);
            novi.setNazivIstorije("IstorijaAktivnosti_"+novi.getUsername());
            dn.kreirajNalog(novi);                   
            dia.unesiAktivnost(TipAktivnosti.KreiranjeNaloga, niz[5], null, "Kreiran nalog");
           
            client.setUsername(novi.getUsername());
            ServerStrana.aktivniKlijenti.add(client);
            
            String povratnaPoruka = "success:" + niz[0] +":"+ niz[1] +":"+ niz[5];
            ServerChatClient.OUT.println(povratnaPoruka);
        }
        
    }
    
    public static void registracija1(ServerChatClient client) throws IOException, FileNotFoundException, SQLException{
        Nalog novi;
        boolean signal = false;
        do{
            if(signal)
                ServerChatClient.OUT.println("bad");
            
            String log = ServerChatClient.IN.readLine();
            String[] niz = log.split(":");//(ime, prezime, datRodjenja, pol, drzava, username, password)               


            // pretvaranje elmenta datum iz niza u niz integera da bismo mogli da kreiramo datum rodjenja novog korisnika
            int[] datum = Arrays.asList(niz[2].split("\\.")).stream().mapToInt(Integer::parseInt).toArray();
            Calendar cal = Calendar.getInstance();
            cal.set(datum[2], datum[1]-1, datum[0]);
            novi = new Nalog(niz[0], niz[1], cal.getTime(), Pol.valueOf(niz[3]), niz[4], null, null, niz[5], niz[6]);
        }while(signal = uporediNalogSaBazom(novi));
        
        
            DaoIstorijaAktivnosti dia = new DaoIstorijaAktivnostiImpl();
            DaoNalog dn = new DaoNalogImpl();
            
            dia.kreirajTabeluAktivnosti(novi.getUsername());
            novi.setNazivIstorije("IstorijaAktivnosti_"+novi.getUsername());
            dn.kreirajNalog(novi);                   
            dia.unesiAktivnost(TipAktivnosti.KreiranjeNaloga, novi.getUsername(), null, "Kreiran nalog");
           
            client.setUsername(novi.getUsername());
            ServerStrana.aktivniKlijenti.add(client);
            
            String povratnaPoruka = "success:" + novi.getIme() +":"+ novi.getPrezime() +":"+ novi.getUsername();
            ServerChatClient.OUT.println(povratnaPoruka);
        
        
    }
    
    public static void prijavljivanje(ServerChatClient client) throws IOException, SQLException{
        String log = ServerChatClient.IN.readLine();
        String[] niz = log.split(":"); // username , password
        
        Nalog novi = new Nalog(niz[0], niz[1]);
        if((novi = uporediNalogSaBazomIVratiNazad(novi)) == null){
            ServerChatClient.OUT.println("bad");
        }else{
            DaoIstorijaAktivnosti dia = new DaoIstorijaAktivnostiImpl();
            dia.unesiAktivnost(TipAktivnosti.Prijavljivanje, niz[0], null, "Korisnik se prijavio");
            
            //ubacivanje klijenta u listu aktivnih klijenata
            client.setUsername(novi.getUsername());
            ServerStrana.aktivniKlijenti.add(client);
            
            String povratnaPoruka = "success:"+ novi.getIme() +":"+ novi.getPrezime() +":"+ novi.getUsername();
            ServerChatClient.OUT.println(povratnaPoruka);
        }
        
    }
    
    public static void prijavljivanje1(ServerChatClient client) throws IOException, SQLException{
        boolean signal = false;
        Nalog novi;
        do{
            if(signal)
                ServerChatClient.OUT.println("bad");
            
            String log = ServerChatClient.IN.readLine();
            String[] niz = log.split(":"); // username , password

            novi = new Nalog(niz[0], niz[1]);        
        }
        while(signal = ((novi = uporediNalogSaBazomIVratiNazad(novi)) == null));
                
        DaoIstorijaAktivnosti dia = new DaoIstorijaAktivnostiImpl();
        dia.unesiAktivnost(TipAktivnosti.Prijavljivanje, novi.getUsername(), null, "Korisnik se prijavio");

        //ubacivanje klijenta u listu aktivnih klijenata
        client.setUsername(novi.getUsername());
        ServerStrana.aktivniKlijenti.add(client);

        String povratnaPoruka = "success:"+ novi.getIme() +":"+ novi.getPrezime() +":"+ novi.getUsername();
        ServerChatClient.OUT.println(povratnaPoruka);                
    }

    public static void osluskivac(String poruka, ServerChatClient client) throws IOException, SQLException {
        switch(poruka){
            case "signup":
                registracija1(client);
                ServerChatClient.OUT.println("Uspesno registrovanje :D");
                break;
            case "signin":
                prijavljivanje1(client);
                ServerChatClient.OUT.println("Uspesno prijavljivanje :D");
                break;
            default:
                break;
        }
    }
    
    private static boolean uporediNalogSaBazom(Nalog nalog) throws IOException, SQLException{
        LinkedList<Nalog> lista = new DaoNalogImpl().vratiSveNaloge();
        if(lista.contains(nalog))
            return true;
        return false;
    }
    
    private static Nalog uporediNalogSaBazomIVratiNazad(Nalog nalog) throws IOException, SQLException{
        LinkedList<Nalog> lista = new DaoNalogImpl().vratiSveNaloge();
        for (Nalog n : lista) {
            if(n.equals(nalog))
                return n;
        }
        return null;
    }
}
