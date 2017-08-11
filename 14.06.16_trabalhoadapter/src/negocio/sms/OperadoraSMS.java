/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.sms;

/**
 *
 * @author Mauricio Capua
 */
public class OperadoraSMS implements SMSSender {

    @Override
    public boolean sendSMS(SMS sms) {
        if (sms != null) {
            System.out.println("Enviando sms: " + sms.toString());
            return true;
        }
        return false;
    }
}
