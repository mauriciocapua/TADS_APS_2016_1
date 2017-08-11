/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Mauricio Capua
 */
public class Texto_Plano extends Template {

    @Override
    protected void processData(ArrayList<Dados> dados) {
        extensao = "txt";
        for (int i = 0; i < dados.size(); i++) {
            saida.add(dados.get(i).getCpf() + " | " + dados.get(i).getNome() + " | " + dados.get(i).getIdade());
        }
    }

}
