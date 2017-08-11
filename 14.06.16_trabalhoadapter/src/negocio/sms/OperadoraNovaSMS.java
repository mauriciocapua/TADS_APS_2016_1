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
public class OperadoraNovaSMS implements EnviadorSMS {

    public OperadoraNovaSMS() {
    }

    @Override
    public void enviarSMS(String destino, String origem, String[] texto) throws Exception {

        for (int i = 0; i < texto.length; i++) {
            System.out.println("Enviando sms: " + destino + " " + origem + " " + texto[i]);

        }
    }

}
