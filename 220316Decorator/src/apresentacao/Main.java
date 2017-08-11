/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import negocio.Bebida;
import negocio.cafes.Expresso;
import negocio.condimentos.Acucar;
import negocio.condimentos.Leite;

/**
 *
 * @author iapereira
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Bebida bebida = new Expresso();
        bebida = new Acucar(bebida);
        bebida = new Leite(bebida);
        bebida = new Acucar(bebida);
        
        System.out.println("Expresso com Açucar:....Ingredientes e Valor:");
        System.out.println(bebida.getDescricao());
        System.out.println("Valor:"+bebida.custo());
        
        
        
        
    }
    
}
