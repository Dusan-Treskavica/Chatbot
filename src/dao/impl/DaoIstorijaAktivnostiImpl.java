/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DaoIstorijaAktivnosti;
import db.ConnectionFactory;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.EnumConnectionType;
import util.TipAktivnosti;

/**
 *
 * @author DusanT
 */
public class DaoIstorijaAktivnostiImpl extends DaoIstorijaAktivnosti {

    Connection connection;
    
    public DaoIstorijaAktivnostiImpl() throws IOException, FileNotFoundException, SQLException{
        connection = ConnectionFactory.createConnection(EnumConnectionType.DRIVER_MANAGER);
    }
    @Override
    public void kreirajTabeluAktivnosti(String username) {
        String query = "CREATE TABLE IstorijaAktivnosti_"+username+
                "(DatumIVreme timestamp NOT NULL, TipDogadjaja ENUM('KreiranjeNaloga', 'Prijavljivanje', 'Odjavljivanje', 'SlanjePoruke', 'PrijemPoruke', 'SlanjeFajla', 'PrijemFajla', 'NaredbaBotu', 'NeprispelaPoruka') NOT NULL,"
                + " Posiljalac varchar(20), Primalac varchar(20), OpisAktivnosti varchar(100), PRIMARY KEY(DatumIVreme))";
        
        Statement stat;
        
        try {
            stat = connection.createStatement();
            stat.execute(query);
            
            
            stat.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoIstorijaAktivnostiImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    @Override
//    public void unesiAktivnost(TipAktivnosti tipAktivnosti, String posiljalac, String opisAktivnosti) {
//        try {
//            String query = "INSERT INTO IstorijaAktivnosti_" + posiljalac + " VALUES(?,?,?,?,?)";
//            PreparedStatement pstat = connection.prepareStatement(query);
//            pstat.setDate(1, new java.sql.Date(new Date().getTime()));
//            pstat.setString(2, tipAktivnosti.name());
//            pstat.setString(3, posiljalac);
//            pstat.setString(4, null);
//            pstat.setString(5, opisAktivnosti);
//            
//            pstat.executeUpdate();
//            pstat.close();
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(DaoIstorijaAktivnostiImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    @Override
    public void unesiAktivnost(TipAktivnosti tipAktivnosti, String posiljalac, String primalac, String opisAktivnosti) {
        try {
            String query = "INSERT INTO IstorijaAktivnosti_" + posiljalac + " VALUES(?,?,?,?,?)";
            PreparedStatement pstat = connection.prepareStatement(query);
            pstat.setTimestamp(1, new java.sql.Timestamp(new Date().getTime()));
            pstat.setString(2, tipAktivnosti.name());
            pstat.setString(3, posiljalac);
            pstat.setString(4, primalac);
            pstat.setString(5, opisAktivnosti);
            
            pstat.executeUpdate();
            pstat.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoIstorijaAktivnostiImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
