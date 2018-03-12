/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Beans.Lote;
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
public class LoteDao {
    
    static Connection connection;
    
    public LoteDao() throws ClassNotFoundException{
        LoteDao.connection = ConnectionFactory.getConnection();
    }
    
    public void insertLote(Lote us) throws SQLException
    {
            PreparedStatement st = this.connection.prepareStatement("insert into lote (`doce`, `quantidade`, `valor_lote`, `usuario`) values (?,?,?,?) "); // 4 ?
            st.setInt(1, us.getDoce());
            st.setString(2, us.getQuantidade());
            st.setString(3, us.getValor_lote());
            st.setInt(4, us.getUsuario());
            st.execute();
    }
    
    public Collection<Lote> todosLotes() throws SQLException {
        try
        {
            List<Lote> jg =new ArrayList<>();
            PreparedStatement st = this.connection.prepareStatement("Select * from lote");
            ResultSet rs = st.executeQuery();
       
            while(rs.next())
            {
                Lote j = new Lote();
                j.setId_lote(rs.getInt("id_lote"));
                j.setDoce(rs.getInt("doce"));
                j.setQuantidade(rs.getString("quantidade"));
                j.setValor_lote(rs.getString("valor_lote"));
                j.setUsuario(rs.getInt("usuario"));
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
    
    public void deleteLote(String id) throws SQLException
    {
        System.out.println("entrou no apagar");
        PreparedStatement st = this.connection.prepareStatement(" DELETE FROM lote WHERE id_lote ='"+ id +"'");
        st.execute();
    }
    
}
