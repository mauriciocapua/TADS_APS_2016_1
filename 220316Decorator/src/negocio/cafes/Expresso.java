/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.cafes;

import negocio.Bebida;

/**
 *
 * @author iapereira
 */
public class Expresso extends Bebida {
    
    public Expresso(){
        this.descricao = "Expresso:"+this.custo();
    }

    @Override
    public double custo() {
        return 2.0;
    }
    
}
