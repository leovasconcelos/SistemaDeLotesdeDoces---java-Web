/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;
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
public class LevarCadastrarLote implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
                String pagina;
        pagina = "/WEB-INF/Paginas/CadastrarLote.jsp";
        return pagina;
    }
    
}
