/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.Decorator;

/**
 *
 * @author Mauricio Capua
 */
public class Auxiliar extends Cargo {

    public Auxiliar() {
        super();
        setSalario(this.getInicial() + 1000);
    }

}
