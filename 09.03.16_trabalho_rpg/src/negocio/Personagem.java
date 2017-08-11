/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import negocio.armas.Punhos;

/**
 *
 * @author Mauricio Capua
 */
public abstract class Personagem {

    protected Arma lutar;

    public Personagem() {
        this.lutar = new Punhos();
    }

    public String retorno() {
        return " ";
    }

    public String nome() {
        return " ";
    }

    public abstract void display();

    public void Lutar() {
        this.lutar.golpe();
    }

    public Arma getLutar() {
        return lutar;
    }

    public void setLutar(Arma lutar) {
        this.lutar = lutar;
    }

    public String Arma_atual() {
        return nome() + " - " + lutar.nome_arma();
    }

    public String Ação() {
        return nome() + " - " + lutar.nome_arma() + ": " + lutar.golpe();
    }

}
