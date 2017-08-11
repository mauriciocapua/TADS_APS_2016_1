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
public interface EnviadorSMS {

    void enviarSMS(String destino, String origem, String[] texto) throws Exception;

}
