/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import modelo.*;
import java.util.Formatter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import static modelo.Item.verifica_item;
import modelo.*;

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

        //Pedido pedido = new Pedido();
        //Pedido a = new Pedido();
        //a.setId(4);
        /*ArrayList<Item> aux = new ArrayList(Arrays.asList(new Item(10, Livro.verifica_livro(2))));
        a.setVetItens(aux);
        a.salvar();*/
       // Item item = new Item(20, a, Livro.verifica_livro(2));
       // item.salvaritem();
        /*
        pedido.setId(3);
        pedido.carregar();
        Pedido.print(pedido);  */
        //Livro.listarTodosLivros();
        /*Item item1 = new Item();
        item1.setId_pedido(2);
        item1.setLivro(Livro.verifica_livro(1));
        item1.setQuantidade_item(10);
        item1.salvaritem();*/
        //listar();
    }

    public static void listar() throws SQLException {
        Formatter formatter = new Formatter();
        System.out.println(formatter.format("%1s %30s %20s", "ID", " | Nome | ", "Pedidos"));
        for (int i = 0; i < Pedido.listarTodos().size(); i++) {
            Pedido.print(Pedido.listarTodos().get(i));
            /*Pedido a = Pedido.listarTodos().get(i);
            a.obterPedidos();
            for (int j = 0; j < a.getVetPedidos().size(); j++) {
                Pedido.print(a.getVetPedidos().get(j));
            }*/
            System.out.println("");
        }
        System.out.println("");
    }
}
