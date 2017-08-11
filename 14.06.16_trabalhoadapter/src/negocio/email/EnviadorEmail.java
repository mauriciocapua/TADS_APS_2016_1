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
public interface EnviadorEmail {

    void enviarEmail(String destino, String assunto, String[] mensagem) throws Exception;

}
