/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import devices.*;

/**
 *
 * @author Mauricio Capua
 */
public class Estudar implements Command {

    private TrabalhodoIgor trabalhodoigor;

    public Estudar(TrabalhodoIgor trabalhodoigor) {
        this.trabalhodoigor = trabalhodoigor;
    }

    public void execute() {
        this.trabalhodoigor.on();
        new PS4().off();
    }

    @Override
    public void undo() {
        this.trabalhodoigor.off();
        new PS4().on();
    }
}
