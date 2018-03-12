/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Doces;
import Dao.DocesDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluno
 */
public class CadastroDoce implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String pagina;
        
        String nome = req.getParameter("nome");
        String Descricao = req.getParameter("descricao");
        String  tipo = req.getParameter("tipo");
        String  preco = req.getParameter("preco");
        
        Doces dc = new Doces();
        
        dc.setNome(nome);
        dc.setDescricao(Descricao);
        dc.setTipo(Integer.valueOf(tipo));
        dc.setPrecoUnitario(preco);
        
        try {
            new DocesDao().insertDoce(dc);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroDoce.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDoce.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        pagina = "/WEB-INF/Paginas/Menu.jsp";
        return pagina;
    }
    
}
