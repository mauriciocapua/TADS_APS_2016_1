/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio Capua
 */
public class DocumentoSQL extends Documento {

    @Override
    public void criadocumento() {
        documento.setExtensão(".sql");
        documento.setTexto("drop database csv_template; \n"
                + "create database csv_template; \n"
                + "\\c csv_template;\n"
                + "create table if not exists csv(texto text); \n");
        String texto = (JOptionPane.showInputDialog("informe o texto: "));
        documento.setTexto(documento.getTexto() + " insert into csv values('" + texto + "');");
        documento.setTexto(documento.getTexto() + " select * from csv;");
    }

}
