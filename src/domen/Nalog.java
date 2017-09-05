/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import util.Pol;

/**
 *
 * @author DusanT
 */
public class Nalog {
    
    private String ime;
    private String prezime;
    private Date datumRodjenja;
   // private Date datumKreiranjaNaloga;
    private Pol pol;
    private String drzava;
    private String nazivIstorije;
    private String srcPathSlike;
    private String username;
    private String password;

    public Nalog() {
    }
    
    public Nalog(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    // Konstruktor BEZ istorijeAktivnosti
    public Nalog(String ime, String prezime, Date datumRodjenja, Pol pol, String drzava, String srcPathSlike, String username, String password) {
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.pol = pol;
        this.drzava = drzava;
        this.srcPathSlike = srcPathSlike;
        this.username = username;
        this.password = password;
    }
    // Konstruktor SA istorijomAktivnosti
    public Nalog(String ime, String prezime, Date datumRodjenja, Pol pol, String drzava, String nazivIstorije, String srcPathSlike, String username, String password) {
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.pol = pol;
        this.drzava = drzava;
        this.nazivIstorije = nazivIstorije;
        this.srcPathSlike = srcPathSlike;
        this.username = username;
        this.password = password;
    }
    
    

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

//    public Date getDatumKreiranjaNaloga() {
//        return datumKreiranjaNaloga;
//    }
//
//    public void setDatumKreiranjaNaloga(Date datumKreiranjaNaloga) {
//        this.datumKreiranjaNaloga = datumKreiranjaNaloga;
//    }

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getNazivIstorije() {
        return nazivIstorije;
    }

    public void setNazivIstorije(String nazivIstorije) {
        this.nazivIstorije = nazivIstorije;
    }

    public String getSrcPathSlike() {
        return srcPathSlike;
    }

    public void setSrcPathSlike(String srcPathSlike) {
        this.srcPathSlike = srcPathSlike;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Nalog other = (Nalog) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nalog{" + "ime=" + ime + ", prezime=" + prezime + ", datumRodjenja=" + datumRodjenja + ", pol=" + pol + ", drzava=" + drzava + ", nazivIstorije=" + nazivIstorije + ", srcPathSlike=" + srcPathSlike + ", username=" + username + ", password=" + password + '}';
    }
    
    

   
    
    
    
}
