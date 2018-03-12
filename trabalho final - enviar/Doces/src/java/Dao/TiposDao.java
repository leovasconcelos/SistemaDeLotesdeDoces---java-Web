/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Beans.Tipos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class TiposDao {
    
    static Connection connection;
    
    public TiposDao() throws ClassNotFoundException{
        TiposDao.connection = ConnectionFactory.getConnection();
    }
    
    public void insertTipos(Tipos tp) throws SQLException
    {
            PreparedStatement st = this.connection.prepareStatement("insert into tipos (`tipo`) values (?) "); // 1 ?
            st.setString(1, tp.getTipo());
            st.execute();
    }
    
    public Collection<Tipos> todosTipos() throws SQLException {
        try
        {
            List<Tipos> jg =new ArrayList<>();
            PreparedStatement st = this.connection.prepareStatement("Select * from tipos");
            ResultSet rs = st.executeQuery();
       
            while(rs.next())
            {
                Tipos j = new Tipos();
                j.setId_tipo(rs.getInt("id_tipo"));
                j.setTipo(rs.getString("tipo"));
                jg.add(j);
            }
            
        return jg;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return null;
        }
        
    }
}
