/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.email;

import negocio.sms.*;

/**
 *
 * @author Mauricio Capua
 */
public interface EmailSender {

    public boolean sendEmail(Email email);
    
}
