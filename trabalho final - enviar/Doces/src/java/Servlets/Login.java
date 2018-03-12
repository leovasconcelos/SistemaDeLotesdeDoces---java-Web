/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Chat;
import Dao.UsuarioDao;
import Beans.Usuario;
import Dao.ChatDao;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aluno
 */
public class Login implements Tarefa{

    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        String pagina;
        
        System.out.println("chegou aqui em cima");

        Usuario usuario = null;
        
        System.out.println("chegou aqui");
        try 
        {
            usuario = new UsuarioDao().buscaPorEmailESenha(email,senha);
        } 
        catch (Exception e) 
        {
            System.out.println(e);  
        }
        
        
        
        if(usuario != null) 
        {
            System.out.println("entrou no if sim");
            HttpSession session = req.getSession();
            session.setAttribute("Usuario", usuario);
            
            Collection<Chat> chat = null;
            try {
                chat = new ChatDao().buscaDeQuem(String.valueOf(usuario.getId()));
                session.setAttribute("Mensagens", chat);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

            
            pagina = "/WEB-INF/Paginas/Menu.jsp";
            return pagina;
        }
        else {
            System.out.println("entrou no if nao");
            pagina = "/WEB-INF/paginas/NãoLogou.jsp";
            return pagina;
        }

    }
}
