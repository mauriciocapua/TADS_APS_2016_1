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
public abstract class DecoradorBebida extends Bebida {
    protected Bebida bebida;
    protected double custo;
    
    public DecoradorBebida(Bebida bebida){
        this.bebida = bebida;
    }
    
    public double getCusto(){
        return this.custo;
    }
    public void setCusto(double custo){
        this.custo = custo;
    }
    
    @Override
    public double custo() {
        return this.getCusto() + this.bebida.custo();
    }
    
    @Override
    public String getDescricao(){
        return this.bebida.getDescricao() + "\n" + this.descricao +":"+this.getCusto();
    }
   
}
