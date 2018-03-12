/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Lote;
import Beans.Usuario;
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
public class CadastroLote implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String pagina;
        
        String doce = req.getParameter("doce");                
        String quantidade = req.getParameter("quantidade");
        String valor = req.getParameter("valor");

        Lote lt = new Lote();
        Usuario dc = new Usuario();
        
        dc = (Usuario) req.getSession().getAttribute("Usuario");
        
        lt.setDoce(Integer.valueOf(doce));
        lt.setQuantidade(quantidade);
        lt.setValor_lote(valor);
        lt.setUsuario(dc.getId());
        
        try {
            new LoteDao().insertLote(lt);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroLote.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroLote.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        pagina = "/WEB-INF/Paginas/Menu.jsp";
        return pagina;
    }
    
    
}
