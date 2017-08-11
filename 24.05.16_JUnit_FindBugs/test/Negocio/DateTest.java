/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mauricio Capua
 */
public class DateTest {

    Date d;

    public DateTest() {

    }
//
//    @BeforeClass
//    public static void setUpClass() throws Exception {
//        System.out.println("Inicializador da Classe de Teste....");
//    }
//
//    @AfterClass
//    public static void tearDownClass() throws Exception {
//        System.out.println("Finalizar da Classe de Teste...");
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        System.out.println("Antes de qualquer caso de teste....");
//     
//    }

//    @After
//    public void tearDown() throws Exception {
//        System.out.println("Depois de qualquer caso de teste...");
//    }
    @Test
    public void testarDatas() {

//             assertEquals(true, d = new Date(1900, 7, 2016));
        //     assertEquals(true, d = new Date(16, -1, 1899));
        //    assertEquals(true, d = new Date(1899, 7, 16));
        //      assertEquals(true, d = new Date(2016, 12, 32));
        //inválido(true, dia inválido)
        //       assertEquals(true, d = new Date(2016, 12, -1));
        //inválido(mês inválido)
//        assertEquals(true, d = new Date(2016, -1, 16));
        //inválido(true, dia inválido)
//        assertEquals(true, d = new Date(2016, 2, 30));
        // inválido (mês inválido)
//        assertEquals(true, d = new Date(2016, 13, 16));
        // toString
        Date d8 = new Date(5, 5, 2005);
        assertEquals(d8.toString(), "05/05/2005");
        d8 = new Date(1, 10, 2001);
        assertEquals(d8.toString(), "01/10/2001");

        // comparações
        Date d5 = new Date(22, 4, 2016);
        Date d6 = new Date(2014, 7, 1);
//        assertEquals(true, d5.equals(d6));
        assertEquals(false, d5.equals(new Date()));

        Date d7 = new Date(23, 4, 2016);
        assertEquals(false, d5.after(d7));
        //assertEquals(true, d5.after(d7));
        assertEquals(true, d7.after(d5));
        assertEquals(true, d5.before(d7));
        assertEquals(false, d7.before(d5));
        assertEquals(false, d7.before(d7));
        assertEquals(false, d7.after(d7));

        // plusDays, minusDays, tomorrow e yesterday
        d = new Date(2016, 4, 22);
        Date d2 = d.yesterday();
        assertEquals(true, d2.getDia() == 21);
        assertEquals(true, d2.getMes() == 4);
        assertEquals(true, d2.getAno() == 2016);

        d2 = d.tomorrow();
        assertEquals(true, d2.getDia() == 23);
        assertEquals(true, d2.getMes() == 4);
        assertEquals(true, d2.getAno() == 2016);

        Date d3 = d2.plusday(10);

        assertEquals(true, d3.getDia() == 3);
        assertEquals(true, d3.getMes() == 5);
        assertEquals(true, d3.getAno() == 2016);

        Date d4 = d3.minusday(10);
        assertEquals(true, d4.getDia() == 23);
        assertEquals(true, d4.getMes() == 4);
        assertEquals(true, d4.getAno() == 2016);

        // situações complexas
        Date q = new Date(20, 2, 2016);
        q = q.plusday(9);
        assertEquals(true, q.toString().equals("29/02/2016"));
        for (int i = 0; i < 400; i++) {
            q = q.tomorrow();
        }

        assertEquals(true, q.toString().equals("04/04/2017"));
        q = q.plusday(365);
        assertEquals(true, q.toString().equals("04/04/2018"));

    }

}
