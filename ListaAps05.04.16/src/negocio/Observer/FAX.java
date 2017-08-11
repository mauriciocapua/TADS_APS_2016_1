/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.Observer;

/**
 *
 * @author Mauricio Capua
 */
public class FAX implements Observer {

    @Override
    public void update() {
        System.out.println("Telefone está tocando");
    }

}
