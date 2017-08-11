/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import java.time.LocalDate;
import negocio.*;

/**
 *
 * @author Mauricio Capua
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Funcionario empregado = new Funcionario("Igor", LocalDate.of(1992, 3, 6), "12345678");
        Funcionario empregado2 = new Funcionario("Igor", LocalDate.of(1992, 3, 6), "");
        Funcionario empregado3 = new Funcionario("Igor", LocalDate.of(1999, 3, 6), "12345678");

        Veiculo carro = new Carro("ka", "ford", 2016, "bla123", "379118faf");

        Gerenciamento gerenciamento = new Gerenciamento(carro, empregado);
        gerenciamento.manobrar();

    }

    /*LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1960, Month.JANUARY, 1);

        Period p = Period.between(birthday, today);*/
}
