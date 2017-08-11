/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apresentacao;

import Negocio.*;

/**
 *
 * @author Mauricio Capua
 */
public class TrabalhoFactoryMethod_19416 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Aplicacao aplicação = new AplicacaoTXT();
        Documento documento = aplicação.criaDocumento();
        documento.criadocumento();
        documento.gravaarquivo();*/
 /*
        Aplicacao aplicação = new AplicacaoSQL();
        Documento documento = aplicação.criaDocumento();
        documento.criadocumento();
        documento.gravaarquivo();*/
        
        Aplicacao aplicação = new AplicacaoXML();
        Documento documento = aplicação.criaDocumento();
        documento.abrearquivo("123213.xml");
    }
    
}
