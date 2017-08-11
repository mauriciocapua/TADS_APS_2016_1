/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.personagens;

import negocio.Personagem;
import negocio.Personagem;

/**
 *
 * @author Mauricio Capua
 */
public class Cavaleiro extends Personagem {

    public Cavaleiro() {
    }

    @Override
    public void display() {
        System.out.println("Cavaleiro Selecionado");
    }

    @Override
    public String retorno() {
        return "Caveleiro Criado";
    }

    @Override
    public String nome() {
        return "Cavaleiro";
    }

}
