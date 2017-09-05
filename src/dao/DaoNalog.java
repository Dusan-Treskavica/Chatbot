/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domen.Nalog;
import java.util.LinkedList;

/**
 *
 * @author DusanT
 */
public abstract class DaoNalog {
    
    public abstract LinkedList<Nalog> vratiSveNaloge();
    public abstract void kreirajNalog(Nalog nalog);
    
}
