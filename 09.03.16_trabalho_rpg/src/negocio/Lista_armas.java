/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import negocio.armas.Arco_e_flecha;
import negocio.armas.Espada;
import negocio.armas.Faca;
import negocio.armas.Machado;

/**
 *
 * @author Mauricio Capua
 */
public class Lista_armas {

    private ArrayList<Arma> listaArmas = new ArrayList<>();

    public Lista_armas() {
        listaArmas.add(new Espada());
        listaArmas.add(new Faca());
        listaArmas.add(new Arco_e_flecha());
        listaArmas.add(new Machado());
    }

    public Arma Retorna_arma(int i_combobox) {
        return listaArmas.get(i_combobox);
    }

    /*
    public String Verifica_arma(String escolha_arma) {
        String retorno = "erro";
        if (null != escolha_arma) {
            switch (escolha_arma) {
                case "Arco e Flecha":
                    retorno = "Arco e Flecha Selecionado";
                    break;
                case "Machado":
                    retorno = "Machado Selecionado";
                    break;
                case "Espada":
                    retorno = "Espada Selecionada";
                    break;
                case "Faca":
                    retorno = "Faca Selecionada";
                    break;

                default:
                    break;
            }
        }
        return retorno;
    }

    public Arma Seleciona_arma(String escolha_arma) {
        Arma arma = null;
        if (null != escolha_arma) {
            switch (escolha_arma) {
                case "Arco e Flecha":
                    arma = new Arco_e_flecha();
                    break;
                case "Machado":
                    arma = new Machado();
                    break;
                case "Espada":
                    arma = new Espada();
                    break;
                case "Faca":
                    arma = new Faca();
                    break;

                default:
                    break;
            }
        }
        return arma;
    }
*/

}
