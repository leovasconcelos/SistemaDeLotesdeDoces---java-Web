/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Beans.Doces;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Aluno
 */
public class DocesDao {
    
    static Connection connection;
    
    public DocesDao() throws ClassNotFoundException{
        DocesDao.connection = ConnectionFactory.getConnection();
    }
    
    public void insertDoce(Doces us) throws SQLException
    {
            PreparedStatement st = this.connection.prepareStatement("insert into doces (`Nome`, `Descricao`, `Tipo`, `PrecoUnitario`)  values (?,?,?,?) "); // 4 ?
            st.setString(1, us.getNome());
            st.setString(2, us.getDescricao());
            st.setInt(3, us.getTipo());
            st.setString(4, us.getPrecoUnitario());
            st.execute();
    }
    
    
    public Doces buscaID(String id) throws SQLException {
        if (id == null){
            return null;
        }
        PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM doces WHERE id_doce = '"+ id +"'");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Doces dc = new Doces();
            dc.setId_doce(rs.getInt("id_doce"));
            dc.setNome(rs.getString("Nome"));
            dc.setDescricao(rs.getString("Descricao"));
            dc.setTipo(rs.getInt("Tipo"));
            dc.setPrecoUnitario(rs.getString("PrecoUnitario"));
            if (dc.getId_doce()== Integer.valueOf(id))
                return dc;
        }  
        rs.close();
        stmt.close();
        return null;
    }
    
}
