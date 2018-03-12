/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Tipos;
import Dao.TiposDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluno
 */
public class CadastroTipo implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String pagina;
        Tipos tp = new Tipos();
        
        String tipo = req.getParameter("tipo");
        tp.setTipo(tipo);
        
        try {
            new TiposDao().insertTipos(tp);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroTipo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroTipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        pagina = "/WEB-INF/Paginas/Menu.jsp";
        return pagina;
    }
    
}
