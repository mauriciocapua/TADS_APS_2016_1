/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apresentacao;

import Negocio.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Mauricio Capua
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here    
        testes();

    }

    public static void testes() {

        ArrayList<Date> datas_minimas = new ArrayList(Arrays.asList(new Date(1, 1, 2016), new Date(1, 2, 2016), new Date(1, 3, 2015), new Date(1, 3, 2016),
                new Date(1, 4, 2016), new Date(1, 5, 2016), new Date(1, 6, 2016), new Date(1, 7, 2016), new Date(1, 8, 2016), new Date(1, 9, 2016),
                new Date(1, 10, 2016), new Date(1, 11, 2016), new Date(1, 12, 2016)));

        for (int i = 0; i < datas_minimas.size(); i++) {
            Date e = datas_minimas.get(i);
            System.out.print("ontem: ");
            e.yesterday().print();
            e.print();
            System.out.print("amanhã: ");
            e.tomorrow().print();
            System.out.println("posição " + i + "\n");
        }

        System.out.println("----------------------------------------------------");

        ArrayList<Date> datas_maximas = new ArrayList(Arrays.asList(new Date(31, 1, 2016), new Date(29, 2, 2016), new Date(28, 2, 2015), new Date(31, 3, 2016),
                new Date(30, 4, 2016), new Date(31, 5, 2016), new Date(30, 6, 2016), new Date(31, 7, 2016), new Date(31, 8, 2016), new Date(30, 9, 2016),
                new Date(31, 10, 2016), new Date(30, 11, 2016), new Date(31, 12, 2016)));

        for (int i = 0; i < datas_maximas.size(); i++) {
            Date e = datas_maximas.get(i);
            System.out.print("ontem: ");
            e.yesterday().print();
            e.print();
            System.out.print("amanha: ");
            e.tomorrow().print();
            System.out.println("posição " + i + "\n");
        }

    }

}
