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
public class AtualizarUs implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        Usuario us = new Usuario();


            HttpSession ses = req.getSession() ;
            us = (Usuario) ses.getAttribute("Usuario");
            //System.out.println("us: "+String.valueOf(idus));

            
            String nome = req.getParameter("nome");
            String dt = req.getParameter("dtnascimento");
            String email = req.getParameter("email");               
            String senha = req.getParameter("senha");
            String endereco = req.getParameter("endereco");    
            String nomeEmpresa = req.getParameter("nomeEmpresa");               
            String tipo = req.getParameter("tipo");
            String cpnj = req.getParameter("cnpj");
            
            System.out.println("senha new "+senha);
            System.out.println("senha old"+us.getSenha());
            
            if(!"".equals(nome))
            {
                us.setNome(nome);
            }
            if(!"".equals(dt))
            {
                us.setDtnascimento(dt);
            }
            if(!"".equals(email))
            {
                us.setEmail(email);
            }
            if(!"".equals(senha))
            {
                us.setSenha(senha); 
            }
            if(!"".equals(endereco))
            {
                us.setEndereco(endereco);
            }
            if(!"".equals(nomeEmpresa))
            {
                us.setNomeEmpresa(nomeEmpresa);
            }
            if(!"".equals(tipo))
            {
                us.setTipo(Integer.valueOf(tipo));
            }
            if(!"".equals(cpnj))
            {
                us.setCnpj(cpnj); 
            }
             

        UsuarioDao usd;
        try {
            usd = new UsuarioDao();
            usd.updateUsuario(us);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AtualizarUs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AtualizarUs.class.getName()).log(Level.SEVERE, null, ex);
        }
            

        String pagina;
        pagina = "/WEB-INF/Paginas/Menu.jsp";
        
        return pagina;
    }
    
}
