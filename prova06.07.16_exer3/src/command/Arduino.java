/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import devices.Botão;
import devices.*;

/**
 *
 * @author Mauricio Capua
 */
public class Arduino implements Command {

    private Command command;

    public void receber(Command command) {
        this.command = command;
    }

    @Override
    public void execute() {
        command.execute();
    }

}
