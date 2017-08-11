/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;

/**
 *
 * @author Mauricio Capua
 */
public class HTML extends Template {

    @Override
    protected void processData(ArrayList<Dados> dados) {
        extensao = "html";
        saida.add("<html><head></head><body><table border = 1>");
        saida.add("<td>" + dados.get(0).getCpf() + "</td><td>" + dados.get(0).getNome() + "</td><td>" + dados.get(0).getIdade() + "</td>");
        for (int i = 1; i < dados.size(); i++) {
            saida.add("<tr><td>" + dados.get(i).getCpf() + "</td><td>" + dados.get(i).getNome()
                    + "</td> <td>" + dados.get(i).getIdade() + "</td></tr>");

        }
        saida.add("</table></body></html>");
    }

}
