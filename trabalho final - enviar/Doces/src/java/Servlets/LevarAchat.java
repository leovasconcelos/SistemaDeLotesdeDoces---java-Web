/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;
import Beans.Chat;
import Beans.Lote;
import Beans.Usuario;
import Dao.ChatDao;
import Dao.LoteDao;
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
public class LevarAchat implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String pagina;
        
       Usuario dc = new Usuario();
        
        dc = (Usuario) req.getSession().getAttribute("Usuario");
        
        Collection<Chat> chat = null;
        try {
            HttpSession session = req.getSession();
            ChatDao chd = new ChatDao();
            chat = chd.paraQuem(String.valueOf(dc.getId()));
            session.setAttribute("msg", chat);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LevarAchat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LevarAchat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        pagina = "/WEB-INF/Paginas/Chat.jsp";
        return pagina;
    }
    
}
