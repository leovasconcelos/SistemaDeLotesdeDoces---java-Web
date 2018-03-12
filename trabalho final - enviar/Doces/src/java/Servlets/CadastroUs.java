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
 * @author Leonardo Vasconcelos
 */
public class CadastroUs implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
            
        String nome = req.getParameter("nome");
        String dt = req.getParameter("dtnascimento");
        String email = req.getParameter("email");               
        String senha = req.getParameter("senha");
        String endereco = req.getParameter("endereco");    
        String nomeEmpresa = req.getParameter("nomeEmpresa");               
        String tipo = req.getParameter("tipo");
        String cpnj = req.getParameter("cnpj");
            
        String pagina;
        Usuario us = new Usuario();
        
        us.setNome(nome);
        us.setDtnascimento(dt);
        us.setEmail(email);
        us.setSenha(senha); 
        us.setEndereco(endereco);
        us.setNomeEmpresa(nomeEmpresa);
        us.setTipo(Integer.valueOf(tipo));
        us.setCnpj(cpnj);
        
        try {
            UsuarioDao usd = new UsuarioDao();
            usd.insertUsuario(us);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroUs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroUs.class.getName()).log(Level.SEVERE, null, ex);
        }
        HttpSession session = req.getSession();
        session.setAttribute("Usuario", us);
        pagina = "/WEB-INF/Paginas/Menu.jsp";
        
        return pagina;
    }
    
}
