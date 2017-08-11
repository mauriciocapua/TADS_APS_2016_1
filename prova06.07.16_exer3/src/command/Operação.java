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
public class Operação implements Command {

    private Botão botão;

    public Operação(Botão botão) {
        this.botão = botão;
    }

    @Override
    public void execute() {
        this.botão.on();
    }

}
