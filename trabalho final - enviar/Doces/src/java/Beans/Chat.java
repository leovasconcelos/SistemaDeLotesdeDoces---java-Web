/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Aluno
 */
public class Chat {
    
    private int id_chat;
    private String mensagem;
    private int paraQuem;
    private int deQuem;

    public int getId_chat() {
        return id_chat;
    }

    public void setId_chat(int id_chat) {
        this.id_chat = id_chat;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getParaQuem() {
        return paraQuem;
    }

    public void setParaQuem(int paraQuem) {
        this.paraQuem = paraQuem;
    }

    public int getDeQuem() {
        return deQuem;
    }

    public void setDeQuem(int deQuem) {
        this.deQuem = deQuem;
    }
    
    
    
}
