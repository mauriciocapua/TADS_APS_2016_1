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
public class Descritor extends DecoradorEmail {

    public Descritor(EmailMolde email) {
        super(email);
        assunto = email.getAssunto();
        destinatario = email.getDestinatario();
        texto_email = (email.getTexto_email() + "\nMINE$OFT");

    }

}
