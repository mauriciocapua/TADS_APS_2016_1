/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import negocio.*;
import java.sql.SQLException;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

/**
 *
 * @author Mauricio Capua
 */
public class Trabalho_ActiveRecord_060516 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Categoria categoria1 = new Categoria();
        negocio.Categoria.listarTodos();

        System.out.println("Nome:" + categoria1.getNome());
       // categoria1.salvar();
        /*
        List<Cliente> vetCliente = Cliente.listarTodos();
        for (int i = 0; i < vetCliente.size(); i++) {
            Cliente aux = vetCliente.get(i);
            System.out.println("Nome:" + aux.getNome());

        }
         */
    }

}
