/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DaoNalog;
import db.ConnectionFactory;
import domen.Nalog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.EnumConnectionType;
import util.Pol;

/**
 *
 * @author DusanT
 */
public class DaoNalogImpl extends DaoNalog{

    Connection connection;
    
    public DaoNalogImpl() throws IOException, SQLException{
        connection = ConnectionFactory.createConnection(EnumConnectionType.DRIVER_MANAGER);
    }
    
    @Override
    public LinkedList<Nalog> vratiSveNaloge() {
        LinkedList<Nalog> listaNaloga = new LinkedList<Nalog>();
        String query = "SELECT * FROM nalog";
        Statement stat;
        
        try {
            stat = connection.createStatement();
            ResultSet rs = stat.executeQuery(query);
            while(rs.next()){
                Nalog nalog = getCurrentRowAktinost(rs);
                listaNaloga.add(nalog);
            }
            stat.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoNalogImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaNaloga;
    }
    
    @Override
    public void kreirajNalog(Nalog nalog){
        try {
            String query = "INSERT INTO nalog VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstat = connection.prepareStatement(query);
            
            pstat.setString(1, nalog.getUsername());
            pstat.setString(2, nalog.getPassword());
            pstat.setString(3, nalog.getIme());
            pstat.setString(4, nalog.getPrezime());
            pstat.setDate(5, new java.sql.Date(nalog.getDatumRodjenja().getTime()));
            pstat.setString(6, nalog.getPol().name());
            pstat.setString(7, nalog.getDrzava());
            pstat.setString(8, nalog.getNazivIstorije());
            pstat.setString(9, null);
            
            pstat.executeUpdate();
            pstat.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoNalogImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Nalog getCurrentRowAktinost(ResultSet rs) throws SQLException {
        String ime = rs.getString("Ime");
        String prezime = rs.getString("Prezime");
        Date datumRodjenja = rs.getDate("DatumRodjenja");
        String drzava = rs.getString("Drzava");
        Pol pol = Pol.valueOf(rs.getString("Pol"));
        String istorijaAktivnosti = rs.getString("IstorijaAktivnosti");
        String username = rs.getString("Username");
        String password = rs.getString("Password");
        
        return new Nalog(ime, prezime, datumRodjenja, pol, drzava,istorijaAktivnosti, null, username, password);
    }
    
}
