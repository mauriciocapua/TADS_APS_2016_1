/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devices;

/**
 *
 * @author Mauricio Capua
 */
public class PS4 extends Tarefa {

    private String jogo;

    public PS4(String jogo) {
        this.jogo = jogo;
    }

    public PS4() {
    }

    public void on() {
        setJogo(jogo);
        System.out.println("Jogando PS4: " + this.jogo);
    }

    public void off() {
        if (jogo == null) {
            System.out.println("Parou de jogar PS4");
        } else {
            System.out.println("Parou de jogar PS4: " + this.jogo);
        }
    }

    public void setJogo(String jogo) {
        if (jogo == null) {
            this.jogo = "No menu";
        } else {
            this.jogo = jogo;
        }
    }

}
