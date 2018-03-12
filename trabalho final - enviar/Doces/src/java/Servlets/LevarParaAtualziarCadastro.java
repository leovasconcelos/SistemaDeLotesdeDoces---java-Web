/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlets;

import Beans.Usuario;
import Dao.UsuarioDao;
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
public class LevarParaAtualziarCadastro implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
    String pagina;
        System.out.println("entrou");
        pagina = "/WEB-INF/Paginas/AtualizarCadastro.jsp";
        Usuario us = new Usuario();
     
            HttpSession ses = req.getSession() ;
            us = (Usuario) ses.getAttribute("Usuario");
            //System.out.println("us: "+String.valueOf(idus));
            //System.out.println("usuario " + us.getNome());

        req.setAttribute("Us", us);
        return pagina;
    }
    
}
