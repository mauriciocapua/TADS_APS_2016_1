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
public class Vereador extends Incorporados {

    public Vereador(Cargo cargo) {
        super(cargo);
        setNome(cargo.getNome());
        setSalario(cargo.getSalario() + 5000);
    }

}
