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
public class Lote {
    
    private int id_lote;
    private int doce;
    private String quantidade; 
    private String valor_lote; 
    private int usuario;

    public int getId_lote() {
        return id_lote;
    }

    public void setId_lote(int id_lote) {
        this.id_lote = id_lote;
    }

    public int getDoce() {
        return doce;
    }

    public void setDoce(int doce) {
        this.doce = doce;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getValor_lote() {
        return valor_lote;
    }

    public void setValor_lote(String valor_lote) {
        this.valor_lote = valor_lote;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    
    
    
    
}
