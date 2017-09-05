/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import util.TipAktivnosti;

/**
 *
 * @author DusanT
 */
public abstract class DaoIstorijaAktivnosti {
    
    public abstract void kreirajTabeluAktivnosti(String username);
   // public abstract void unesiAktivnost(TipAktivnosti tipAktivnosti, String posiljalac, String opisAktivnosti);
    public abstract void unesiAktivnost(TipAktivnosti tipAktivnosti, String posiljalac, String primalac, String opisAktivnosti);
}
