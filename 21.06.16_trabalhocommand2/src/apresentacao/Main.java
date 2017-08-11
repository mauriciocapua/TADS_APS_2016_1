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
        Fimdesemestre finaldesemestre = new Fimdesemestre();
        TrabalhodoIgor trabalhocommand = new TrabalhodoIgor("command");
        PS4 ps4lindo = new PS4("goat simulator");

        Jogar jogar = new Jogar(ps4lindo);
        Estudar estudar = new Estudar(trabalhocommand);

        finaldesemestre.oquefazer(jogar);
        finaldesemestre.execute();

        System.out.println("\nmany years later\n");

        finaldesemestre.undo();

    }

}
