/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Date;
import java.util.Objects;
import util.TipAktivnosti;

/**
 *
 * @author DusanT
 */
public class IstorijaAktivnostiKlijenta {
    private Date datumIVremeAktivnosti;
    private TipAktivnosti tipAktivnosti;
    private String posiljalac;
    private String primalac;
    private String opisAktivnosti;

    public IstorijaAktivnostiKlijenta() {
    }

    public IstorijaAktivnostiKlijenta(Date datumIVremeAktivnosti, TipAktivnosti tipAktivnosti, String opisAktivnosti) {
        this.datumIVremeAktivnosti = datumIVremeAktivnosti;
        this.tipAktivnosti = tipAktivnosti;
        this.opisAktivnosti = opisAktivnosti;
    }
    
    public IstorijaAktivnostiKlijenta(Date datumIVremeAktivnosti, TipAktivnosti tipAktivnosti, String posiljalac, String opisAktivnosti) {
        this.datumIVremeAktivnosti = datumIVremeAktivnosti;
        this.tipAktivnosti = tipAktivnosti;
        this.posiljalac = posiljalac;
        this.opisAktivnosti = opisAktivnosti;
    }
    
    public IstorijaAktivnostiKlijenta(Date datumIVremeAktivnosti, TipAktivnosti tipAktivnosti, String posiljalac, String primalac, String opisAktivnosti) {
        this.datumIVremeAktivnosti = datumIVremeAktivnosti;
        this.tipAktivnosti = tipAktivnosti;
        this.posiljalac = posiljalac;
        this.primalac = primalac;
        this.opisAktivnosti = opisAktivnosti;
    }
    
    

    public Date getDatumIVremeAktivnosti() {
        return datumIVremeAktivnosti;
    }

    public void setDatumIVremeAktivnosti(Date datumIVremeAktivnosti) {
        this.datumIVremeAktivnosti = datumIVremeAktivnosti;
    }

    public TipAktivnosti getTipAktivnosti() {
        return tipAktivnosti;
    }

    public void setTipAktivnosti(TipAktivnosti tipAktivnosti) {
        this.tipAktivnosti = tipAktivnosti;
    }

    public String getPosiljalac() {
        return posiljalac;
    }

    public void setPosiljalac(String posiljalac) {
        this.posiljalac = posiljalac;
    }

    public String getPrimalac() {
        return primalac;
    }

    public void setPrimalac(String primalac) {
        this.primalac = primalac;
    }

    public String getOpisAktivnosti() {
        return opisAktivnosti;
    }

    public void setOpisAktivnosti(String opisAktivnosti) {
        this.opisAktivnosti = opisAktivnosti;
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
        final IstorijaAktivnostiKlijenta other = (IstorijaAktivnostiKlijenta) obj;
        if (!Objects.equals(this.datumIVremeAktivnosti, other.datumIVremeAktivnosti)) {
            return false;
        }
        if (this.tipAktivnosti != other.tipAktivnosti) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "IstorijaAktivnostiKlijenta{" + "datumIVremeAktivnosti=" + datumIVremeAktivnosti + ", tipAktivnosti=" + tipAktivnosti + ", posiljalac=" + posiljalac + ", primalac=" + primalac + ", opisAktivnosti=" + opisAktivnosti + '}';
    }

    
    
    
            
}
