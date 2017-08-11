/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaaps05.pkg04.pkg16;

import java.util.Random;
import negocio.Decorator.*;

/**
 *
 * @author Mauricio Capua
 */
public class ListaAps050416_decorator {

    public static void main(String[] args) {

        Cargo c = new Auxiliar();
        c.setNome("John");
        c.Mostrar();
        c = new Prefeito(c);
        c.Mostrar();
        c = new Vereador(c);
        c.Mostrar();
    }
}
