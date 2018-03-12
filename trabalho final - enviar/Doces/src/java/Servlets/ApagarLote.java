/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Dao.LoteDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluno
 */
public class ApagarLote implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String pagina;
        
        String lote = req.getParameter("lote");     
        
        try {
            new LoteDao().deleteLote(lote);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApagarLote.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ApagarLote.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        pagina = "/WEB-INF/Paginas/Menu.jsp";
        return pagina;
        
    }
    
}
