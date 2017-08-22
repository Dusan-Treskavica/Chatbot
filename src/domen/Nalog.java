/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Date;
import util.Pol;

/**
 *
 * @author DusanT
 */
public class Nalog {
    
    private String ime;
    private String prezime;
    private Date datumRodjenja;
    private Date datumKreiranjaNaloga;
    private Pol pol;

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

    public Date getDatumKreiranjaNaloga() {
        return datumKreiranjaNaloga;
    }

    public void setDatumKreiranjaNaloga(Date datumKreiranjaNaloga) {
        this.datumKreiranjaNaloga = datumKreiranjaNaloga;
    }

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }
    
    
    
}
