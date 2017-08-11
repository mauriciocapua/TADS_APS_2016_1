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
public class Rei extends Personagem {

    public Rei() {

    }

    @Override
    public void display() {
        System.out.println("Rei Selecionado");
    }

    @Override
    public String retorno() {
        return "Rei Criado";
    }

    @Override
    public String nome() {
        return "Rei";
    }

}
