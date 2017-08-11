/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.Strategy;

import java.util.Calendar;

/**
 *
 * @author Mauricio Capua
 */
public class Regular implements Promocao {

    @Override
    public Double Descontar(Double preco) {
        Calendar calendar = Calendar.getInstance();
        if ((calendar.get(calendar.MONTH)) % 2 == 0) {
            return preco;
        }

        {

        }
        return preco
                * 0.9;
    }

}
