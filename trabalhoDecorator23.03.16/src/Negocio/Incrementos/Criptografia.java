/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.Incrementos;

import Negocio.*;

/**
 *
 * @author Mauricio Capua
 */
public class Criptografia extends DecoradorEmail {

    public Criptografia(EmailMolde email) {
        super(email);
        assunto = email.getAssunto();
        destinatario = email.getDestinatario();

        if (email.getTexto_email() != null) {
            for (int i = 0; i < email.getTexto_email().length(); i++) {
                this.texto_email += Integer.toBinaryString(email.getTexto_email().charAt(i));

            }
        } else {
            this.texto_email = "";
        }
    }

}
