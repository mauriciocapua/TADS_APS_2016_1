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
public class ModeloDocumento {

    private String extensão;
    private String texto;

    public ModeloDocumento(String extensão, String texto) {
        this.extensão = extensão;
        this.texto = texto;
    }

    public ModeloDocumento(String extensão) {

    }

    public ModeloDocumento() {

    }

    public String getExtensão() {
        return extensão;
    }

    public void setExtensão(String extensão) {
        this.extensão = extensão;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
