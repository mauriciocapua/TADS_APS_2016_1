/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.email;

import negocio.sms.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauricio Capua
 */
public class EmailAdapter implements EmailSender {

    private EnviadorEmail enviadoremail;

    public EmailAdapter(EnviadorEmail enviadoremail) {
        this.enviadoremail = enviadoremail;
    }

    @Override
    public boolean sendEmail(Email email) {
        try {
            String[] mensagens = splitStringEvery(email.getTexto_email(), 160);
            enviadoremail.enviarEmail(email.getDestinatario(), email.getAssunto(), mensagens);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(EmailAdapter.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public String[] splitStringEvery(String s, int interval) {
        int arrayLength = (int) Math.ceil(((s.length() / (double) interval)));
        String[] result = new String[arrayLength];

        int j = 0;
        int lastIndex = result.length - 1;
        for (int i = 0; i < lastIndex; i++) {
            result[i] = s.substring(j, j + interval);
            j += interval;
        } //Add the last bit
        result[lastIndex] = s.substring(j);

        return result;
    }
}
