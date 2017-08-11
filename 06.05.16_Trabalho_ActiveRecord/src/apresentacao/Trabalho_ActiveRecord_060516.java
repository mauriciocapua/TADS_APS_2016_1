/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import negocio.*;
import java.util.Formatter;

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
        listar();

        Produto produto = new Produto();
        Categoria categoria = new Categoria();

        produto.setId(3);
        produto.setNome("produto3");
        produto.setValor(30);
        produto.carregar();
        listar();
    }

    public static void listar() throws SQLException {
        Formatter formatter = new Formatter();
        System.out.println(formatter.format("%1s %30s %20s", "ID", " | Nome | ", "Produtos"));
        for (int i = 0; i < Categoria.listarTodos().size(); i++) {
            Categoria.print(Categoria.listarTodos().get(i));
            Categoria a = Categoria.listarTodos().get(i);
            a.obterProdutos();
            for (int j = 0; j < a.getVetProdutos().size(); j++) {
                Produto.print(a.getVetProdutos().get(j));
            }
            System.out.println("");
        }
        System.out.println("");
    }

}
