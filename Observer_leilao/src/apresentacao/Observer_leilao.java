/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import negocio.Leilao;
import negocio.Participante;

/**
 *
 * @author Mauricio Capua
 */
public class Observer_leilao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Leilao leilão = new Leilao();
        leilão.Maior_lance();
        leilão.subscribeParticipante(new Participante(50, "p1"));
        leilão.Maior_lance();
        leilão.subscribeParticipante(new Participante(100, "p2"));
        leilão.Maior_lance();

    }

}
