/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.condimentos;

import negocio.Bebida;
import negocio.DecoradorBebida;

/**
 *
 * @author iapereira
 */
public class Leite extends DecoradorBebida {
    
    public Leite(Bebida bebida){        
        super(bebida);
        descricao = "Leite";
        this.custo = 0.5;
    }
    
    
}
