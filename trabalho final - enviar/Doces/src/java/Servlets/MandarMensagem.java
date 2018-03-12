/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Chat;
import Beans.Usuario;
import Dao.ChatDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aluno
 */
public class MandarMensagem implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        Chat ch = new Chat();
        Usuario us = new Usuario();
        
        String para = req.getParameter("para");
        String mensagem = req.getParameter("mensagem");
        
        ch.setParaQuem(Integer.valueOf(para));
        ch.setMensagem(mensagem);
        us = (Usuario) session.getAttribute("Usuario");
        ch.setDeQuem(us.getId());
        
        try {
            new ChatDao().insertChat(ch);
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(MandarMensagem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MandarMensagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String pagina;
        pagina = "/WEB-INF/Paginas/Chat.jsp";
        return pagina;
    }
    
}
