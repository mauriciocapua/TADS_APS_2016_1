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
public class Acucar extends DecoradorBebida {

    public Acucar(Bebida bebida) {
        super(bebida);
        this.descricao = "Açucar";
        this.custo = 4.0;
    }
    
    
}
