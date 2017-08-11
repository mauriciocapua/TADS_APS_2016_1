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
public abstract class Incorporados extends Cargo {

    protected Cargo cargo;

    public Incorporados(Cargo cargo) {
        super();
        this.cargo = cargo;
        setNome(cargo.getNome());
    }

}
