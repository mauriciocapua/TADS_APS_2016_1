/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import java.sql.SQLException;
import negocio.Twitter;
import negocio.TwitterAdapter;
import negocio.TwitterModificado;

/**
 *
 * @author Mauricio Capua
 */
public class Prova060716 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        String msg = "provinha marota";
        //Twitter twitter = new Twitter();
        //twitter.send(msg);

        TwitterModificado twittermodificado = new TwitterModificado();
        TwitterAdapter adapter = new TwitterAdapter(twittermodificado);
        adapter.send(msg);
    }

}
