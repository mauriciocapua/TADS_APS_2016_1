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
public class Xml extends Template {

    @Override
    protected void processData(ArrayList<Dados> dados) {
        extensao = "xml";
        saida.add("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n"
                + "<csvconvertido>\n<linhas>");

        //saida.add("<cabeçalho>" + cpf.get(0) + nome.get(0) + idade.get(0) + "</cabeçalho>");
        for (int i = 0; i < dados.size(); i++) {
            saida.add("<linha>" + dados.get(i).getCpf() + " | " + dados.get(i).getNome() + " | "
                    + dados.get(i).getIdade() + "</linha>");
        }
        saida.add("</linhas>\n</csvconvertido>");
    }

}
