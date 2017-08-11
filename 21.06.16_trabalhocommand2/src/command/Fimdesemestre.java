/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import devices.Tarefa;
import devices.*;

/**
 *
 * @author Mauricio Capua
 */
public class Fimdesemestre implements Command {

    private Command command;

    public void oquefazer(Command command) {
        this.command = command;
    }

    @Override
    public void execute() {
        command.execute();
    }

    @Override
    public void undo() {
        command.undo();
    }
}
