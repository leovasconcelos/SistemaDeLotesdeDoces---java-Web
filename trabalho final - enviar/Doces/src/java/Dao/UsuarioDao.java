/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Beans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class UsuarioDao {
    
    static Connection connection;
    
    public UsuarioDao() throws ClassNotFoundException{
        UsuarioDao.connection = ConnectionFactory.getConnection();
    }
    
    public void insertUsuario(Usuario us) throws SQLException
    {
        if(us.getTipo() == 1){//DISTRIBUIDOR
            PreparedStatement st = this.connection.prepareStatement("insert into usuario(nome,email,senha,endereco,tipo,cnpj) values (?,?,?,?,?,?) "); // 6 ?
            st.setString(1, us.getNome());
            st.setString(2, us.getEmail());
            st.setString(3, us.getSenha());
            st.setString(4, us.getEndereco());
            st.setInt(5, us.getTipo());
            st.setString(6, us.getCnpj());
            st.execute();
        }
        else
        {
            PreparedStatement st = this.connection.prepareStatement("insert into usuario(nome,dataNascimento,email,senha,endereco,nomeEmpresa,tipo,cnpj) values (?,?,?,?,?,?,?,?) "); // 8 ?
            st.setString(1, us.getNome());
            st.setString(2, us.getDtnascimento());
            st.setString(3, us.getEmail());
            st.setString(4, us.getSenha());
            st.setString(5, us.getEndereco());
            st.setString(6, us.getNomeEmpresa());
            st.setInt(7, us.getTipo());
            st.setString(8, us.getCnpj());
            st.execute();
        }

    }
    
    
    public void updateUsuario(Usuario us) throws SQLException
    {
        
        if(us.getTipo() == 1){//DISTRIBUIDOR
            PreparedStatement st = this.connection.prepareStatement("UPDATE `usuario`set nome = ?,email = ?,senha = ?,endereco = ?,tipo = ?,cnpj = ? WHERE `idusuario`= ?  "); // 6 ?
            System.out.println("entrou no update");
            st.setString(1, us.getNome());
            st.setString(2, us.getEmail());
            st.setString(3, us.getSenha());
            st.setString(4, us.getEndereco());
            st.setInt(5, us.getTipo());
            st.setString(6, us.getCnpj());
            st.setInt(7, us.getId());
            st.execute();
        }
        else
        {
            PreparedStatement st = this.connection.prepareStatement("UPDATE usuario SET nome = ?,dataNascimento = ?,email = ?,senha = ?,endereco = ?,nomeEmpresa = ?,tipo = ?,cnpj = ? WHERE `id_distribuidor`= ? "); // 8 ?
            System.out.println("entrou no update");
            st.setString(1, us.getNome());
            st.setString(2, us.getDtnascimento());
            st.setString(3, us.getEmail());
            st.setString(4, us.getSenha());
            st.setString(5, us.getEndereco());
            st.setString(6, us.getNomeEmpresa());
            st.setInt(7, us.getTipo());
            st.setString(8, us.getCnpj());
            st.setInt(9, us.getId());
            st.execute();
        }
    }
    
        public Usuario buscaPorEmailESenha(String email, String senha) throws SQLException {
        if (email == null || senha == null){
            return null;
        }
        PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM usuario WHERE email = '" + email + "' and senha ='"+ senha+"'");
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Usuario dc = new Usuario();
            dc.setId(rs.getInt("id_distribuidor"));
            dc.setNome(rs.getString("nome"));
            dc.setDtnascimento(rs.getString("datanascimento"));
            dc.setEmail(rs.getString("email"));
            dc.setSenha(rs.getString("senha"));
            dc.setEndereco(rs.getString("endereco"));
            dc.setNomeEmpresa(rs.getString("nomeEmpresa"));
            dc.setTipo(rs.getInt("tipo"));
            dc.setCnpj(rs.getString("cnpj"));
            if (dc.getSenha().equals(senha))
                return dc;
        }  
        rs.close();
        stmt.close();
        return null;
    }
        
        
    public Usuario buscaID(String id) throws SQLException {
        if (id == null){
            return null;
        }
        PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM usuario WHERE id_distribuidor = '"+ id +"'");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Usuario dc = new Usuario();
            dc.setId(rs.getInt("id_distribuidor"));
            dc.setNome(rs.getString("nome"));
            dc.setDtnascimento(rs.getString("datanascimento"));
            dc.setEmail(rs.getString("email"));
            dc.setSenha(rs.getString("senha"));
            dc.setEndereco(rs.getString("endereco"));
            dc.setNomeEmpresa(rs.getString("nomeEmpresa"));
            dc.setTipo(rs.getInt("tipo"));
            dc.setCnpj(rs.getString("cnpj"));        
            
            if (dc.getId()== Integer.valueOf(id))
                return dc;
        }  
        rs.close();
        stmt.close();
        return null;
    }
    
    
}
