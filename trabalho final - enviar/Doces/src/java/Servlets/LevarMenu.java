/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leonardo Vasconcelos
 */
public class LevarMenu implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String pagina;
        pagina = "/WEB-INF/Paginas/Menu.jsp";
        return pagina;
    }
    
}
