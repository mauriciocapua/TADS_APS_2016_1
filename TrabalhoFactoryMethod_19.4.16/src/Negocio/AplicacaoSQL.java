/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Mauricio Capua
 */
public class AplicacaoSQL extends Aplicacao {

    @Override
    public Documento criaDocumento() {
        return new DocumentoSQL();
    }

}
