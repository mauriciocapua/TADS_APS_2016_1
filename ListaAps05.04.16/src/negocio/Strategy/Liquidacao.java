/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.Strategy;

/**
 *
 * @author Mauricio Capua
 */
public class Liquidacao implements Promocao {

    @Override
    public Double Descontar(Double preco) {
        return preco - (preco * 30 / 100);
    }

}
