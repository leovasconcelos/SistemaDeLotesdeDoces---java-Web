/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leonardo Vasconcelos
 */
public class Controller extends HttpServlet{
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String tarefa = req.getParameter("tarefa");
            
        if(tarefa==null) {
                throw new IllegalArgumentException("você esqueceu de passar a tarefa!");
        }
        
        tarefa = "Servlets." + tarefa;
    
        
        try {    
            //chamar uma tarefa
            Class<?> classe = Class.forName(tarefa);
            Tarefa instancia = (Tarefa) classe.newInstance();
            String pagina = instancia.executa(req, resp);
            
            //para onde redirecionar?
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(pagina);
            //redirecionar
            requestDispatcher.forward(req, resp);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
