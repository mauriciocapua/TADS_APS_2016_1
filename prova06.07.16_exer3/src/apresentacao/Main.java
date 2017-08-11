/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import command.*;
import devices.*;

/**
 *
 * @author Mauricio Capua
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        
        Arduino arduino = new Arduino();
        Hibernate hibernate = new Hibernate();
        Shutdown shutdown = new Shutdown();
        Restart restart = new Restart();

        Operação operação = new Operação(restart);

        arduino.receber(operação);
        arduino.execute();

    }

}
