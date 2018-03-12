/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;
import Beans.Lote;
import Dao.LoteDao;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Aluno
 */
public class BuscarLotes implements Tarefa{
    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        Collection<Lote> lote = null;
        
        try {
            lote = new LoteDao().todosLotes();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuscarLotes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BuscarLotes.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("lote", lote);
        return "/WEB-INF/Paginas/TodosLotes.jsp";
    }
}
