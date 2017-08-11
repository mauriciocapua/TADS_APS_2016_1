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
public class DocumentoXML extends Documento {

    @Override
    public void criadocumento() {
        documento.setExtensão(".xml");
        documento.setTexto("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n"
                + "<arquivo>\n<linhas> \n  <linha> ");
        String texto = (JOptionPane.showInputDialog("informe o texto: "));
        documento.setTexto(documento.getTexto() + texto);
        documento.setTexto(documento.getTexto() + "</linha> \n </linhas>\n</arquivo>");
    }

}
