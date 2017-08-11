/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.sms;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauricio Capua
 */
public class SMSAdapter implements SMSSender {

    private EnviadorSMS enviadorsms;

    public SMSAdapter(EnviadorSMS enviadorsms) {
        this.enviadorsms = enviadorsms;
    }

    @Override
    public boolean sendSMS(SMS sms) {
        try {
            String[] mensagem = splitStringEvery(sms.getTexto(), 160);
            enviadorsms.enviarSMS(sms.getOrigem(), sms.getDestino(), mensagem);
        } catch (Exception ex) {
            Logger.getLogger(SMSAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
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
