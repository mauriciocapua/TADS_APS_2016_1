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
public class Prefeito extends Incorporados {

    public Prefeito(Cargo cargo) {
        super(cargo);
        setSalario(cargo.getSalario() + 4000);
    }

}
