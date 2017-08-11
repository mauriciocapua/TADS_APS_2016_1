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
public class Rainha extends Personagem {

    @Override
    public void display() {
        System.out.println("Rainha Selecionada");
    }

    @Override
    public String retorno() {
        return "Rainha Criada";
    }

    @Override
    public String nome() {
        return "Rainha";
    }

    public Rainha() {
    }

}
