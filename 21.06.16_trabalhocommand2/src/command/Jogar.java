/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import devices.PS4;
import devices.TrabalhodoIgor;

/**
 *
 * @author Mauricio Capua
 */
public class Jogar implements Command {

    private PS4 ps4;

    public Jogar(PS4 ps4) {
        this.ps4 = ps4;
    }

    @Override
    public void execute() {
        this.ps4.on();
        new TrabalhodoIgor().off();
    }

    @Override
    public void undo() {
        this.ps4.off();
        new TrabalhodoIgor().on();
    }
}
