/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.armas;

import negocio.Arma;
import negocio.Arma;

/**
 *
 * @author Mauricio Capua
 */
public class Espada implements Arma {

    @Override
    public String golpe() {
        return "Dano 70";
    }

    @Override
    public String nome_arma() {
        return "Espada";
    }

}
