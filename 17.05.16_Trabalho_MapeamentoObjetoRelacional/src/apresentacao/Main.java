/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import repositorio.*;
import modelo.*;
import persistencia.*;
import java.sql.SQLException;
import modelo.Categoria;
import modelo.Produto;
import java.util.Formatter;
import repositorio.*;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio Capua
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        listar();
        RepositorioPedido repositoriopedido = new RepositorioPedido();
        //repositoriopedido.selecionarTodos();
        Livro livro1 = new Livro();
        Item item1 = new Item(1, 2, livro1, 3);

    }

    public static void listar() throws SQLException {
        Formatter formatter = new Formatter();
        System.out.println(formatter.format("%1s %30s %20s", "ID", " | Nome | ", "Produtos"));
        for (int i = 0; i < PedidoDAO.listarTodos().size(); i++) {
            PedidoDAO.listarTodos().get(i).toString();
            /*Categoria a = RepositorioPedido.listarTodos().get(i);
            for (int j = 0; j < RepositorioCategoria.obterProdutos(a).size(); j++) {
                Produto.print(RepositorioCategoria.obterProdutos(a).get(j));
            }*/
            System.out.println("");
        }
        System.out.println("");
    }
}
