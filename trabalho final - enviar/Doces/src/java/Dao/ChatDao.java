/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Beans.Chat;
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
public class ChatDao {
    
    static Connection connection;
    
    public ChatDao() throws ClassNotFoundException{
        ChatDao.connection = ConnectionFactory.getConnection();
    }
    
    public void insertChat(Chat chat) throws SQLException
    {
            PreparedStatement st = this.connection.prepareStatement("insert into chat  (`mensagem`, `paraQuem`, `deQuem`) values (?,?,?) "); // 4 ?
            st.setString(1, chat.getMensagem());
            st.setInt(2, chat.getParaQuem());
            st.setInt(3, chat.getDeQuem());
            st.execute();
    }
    
    public Collection<Chat> paraQuem(String id) throws SQLException {
        try
        {
        List<Chat> jg =new ArrayList<>();
        PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM chat WHERE deQuem = '"+ id +"'");
        ResultSet rs = stmt.executeQuery();
       
            while(rs.next())
            {
               Chat dc = new Chat();
                dc.setId_chat(rs.getInt("id_chat"));
                dc.setMensagem(rs.getString("mensagem"));
                dc.setParaQuem(rs.getInt("paraQuem"));
                dc.setDeQuem(rs.getInt("deQuem"));
                jg.add(dc);
            }
            
        return jg;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    
   
    public Collection<Chat> buscaDeQuem(String id) throws SQLException {
        try
        {
            List<Chat> jg =new ArrayList<>();
            PreparedStatement st = this.connection.prepareStatement("SELECT * FROM chat WHERE paraQuem = '"+ id +"'");
            ResultSet rs = st.executeQuery();
       
            while(rs.next())
            {
               Chat dc = new Chat();
                dc.setId_chat(rs.getInt("id_chat"));
                dc.setMensagem(rs.getString("mensagem"));
                dc.setParaQuem(rs.getInt("paraQuem"));
                dc.setDeQuem(rs.getInt("deQuem"));
                jg.add(dc);
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
