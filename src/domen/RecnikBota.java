/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Objects;

/**
 *
 * @author DusanT
 */
public class RecnikBota {
    private int sifraKljucneReci;
    private String kljucnaRec;

    public RecnikBota() {
    }

    public RecnikBota(int sifraKljucneReci, String kljucnaRec) {
        this.sifraKljucneReci = sifraKljucneReci;
        this.kljucnaRec = kljucnaRec;
    }

    public int getSifraKljucneReci() {
        return sifraKljucneReci;
    }

    public void setSifraKljucneReci(int sifraKljucneReci) {
        this.sifraKljucneReci = sifraKljucneReci;
    }

    public String getKljucnaRec() {
        return kljucnaRec;
    }

    public void setKljucnaRec(String kljucnaRec) {
        this.kljucnaRec = kljucnaRec;
    }

//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 83 * hash + this.sifraKljucneReci;
//        hash = 83 * hash + Objects.hashCode(this.kljucnaRec);
//        return hash;
//    }

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
        final RecnikBota other = (RecnikBota) obj;
        if (this.sifraKljucneReci != other.sifraKljucneReci) {
            return false;
        }
        if (!Objects.equals(this.kljucnaRec, other.kljucnaRec)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RecnikBota{" + "sifraKljucneReci=" + sifraKljucneReci + ", kljucnaRec=" + kljucnaRec + '}';
    }
    
    
    
    
}
