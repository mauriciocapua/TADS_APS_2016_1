/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author iapereira
 */
public abstract class Bebida {
    protected String descricao;
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public abstract double custo();
    
    
    
}
