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
public class Sql extends Template {

    @Override
    protected void processData(ArrayList<Dados> dados) {
extensao = "sql";
        saida.add("drop database csv_template; \n"
                + "create database csv_template; \n"
                + "\\c csv_template;\n"
                + "create table if not exists csv(cpf varchar(15) primary key, nome varchar(200), idade integer); \n");

        for (int i = 1; i < dados.size(); i++) {

            saida.add("insert into csv values('" + dados.get(i).getCpf() + "', '" + dados.get(i).getNome() + "', " + dados.get(i).getIdade() + ");");

        }
        saida.add("select * from csv;");
    }

}
