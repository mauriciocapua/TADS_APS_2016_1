/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Email;

import Negocio.*;

/**
 *
 * @author Mauricio Capua
 */
public class Email extends EmailMolde {

    public Email(String destinatario, String assunto, String texto_email) {
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.texto_email = texto_email;
    }

    public Email() {
    }

    @Override
    public boolean Envio(String destinatario, String assunto, String texto) {
        return super.Envio(destinatario, assunto, texto); //To change body of generated methods, choose Tools | Templates.
    }

}
