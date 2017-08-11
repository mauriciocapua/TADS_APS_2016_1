/* To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import negocio.personagens.Cavaleiro;
import negocio.personagens.Rei;
import negocio.personagens.Rainha;
import java.awt.List;
import java.beans.PersistenceDelegate;
import java.util.ArrayList;

/**
 *
 * @author Mauricio Capua
 */
public class Lista_personagem {

    private ArrayList<Personagem> personagem_array = new ArrayList<>();
    private ArrayList<Personagem> listaPersonagens = new ArrayList<>();

    public void Lista_personagem() {
        // this.listaPersonagens = new ArrayList<>();
        listaPersonagens.clear();
        listaPersonagens.add(new Rainha());
        listaPersonagens.add(new Rei());
        listaPersonagens.add(new Cavaleiro());
    }

    public void Guarda_personagem_array(Personagem personagem) {
        personagem_array.add(personagem);
    }

    public Personagem Retorna_Personagem(int i_combobox) {
        return listaPersonagens.get(i_combobox);
    }

    public ArrayList<Personagem> getPersonagem_array() {
        return personagem_array;
    }

    public ArrayList<Personagem> getListaPersonagens() {
        return listaPersonagens;
    }
}
