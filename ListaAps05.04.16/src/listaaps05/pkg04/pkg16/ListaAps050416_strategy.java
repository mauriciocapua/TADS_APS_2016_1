/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaaps05.pkg04.pkg16;

import negocio.Strategy.*;

/**
 *
 * @author Mauricio Capua
 */
public class ListaAps050416_strategy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DVD dvd = new DVD();
        dvd.setNome("dvd1");
        dvd.setPreco(10.0);
        System.out.println(dvd.getPreco());
        dvd.setP(new Regular());
        System.out.println(dvd.getPreco());
        dvd.setP(new Liquidacao());
        System.out.println(dvd.getPreco());
        dvd.setPagamento(new Debito().Pagar());
        System.out.println(dvd.getPagamento());
    }

}
