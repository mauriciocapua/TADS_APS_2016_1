/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaaps05.pkg04.pkg16;

import negocio.Observer.Telefone;
import negocio.Observer.*;

/**
 *
 * @author Mauricio Capua
 */
public class ListaAps050416_observer {
    
    public static void main(String[] args) {
        Telefone t = new Telefone();
        t.setToque(true);
        t.subscribeObservador(new FAX());
        t.TelefoneToca();
    }
}
