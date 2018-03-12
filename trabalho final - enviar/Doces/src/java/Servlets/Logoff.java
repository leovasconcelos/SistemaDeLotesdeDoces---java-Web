/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Usuario;
import Dao.UsuarioDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aluno
 */
public class Logoff implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String pagina;    
        System.out.println("entrou no if sim");
        HttpSession session = req.getSession();
        session.setAttribute("Usuario", null);
            
        pagina = "index.html";
        return pagina;

    }
    
}
