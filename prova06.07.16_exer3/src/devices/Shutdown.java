/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devices;

/**
 *
 * @author Mauricio Capua
 */
public class Shutdown extends Botão {

    public Shutdown() {
    }

    @Override
    public void on() {
        System.out.println("shutdown funcionando");
    }
}
