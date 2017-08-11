/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import modelo.Categoria;
import modelo.Produto;
import java.util.Formatter;
import repositorio.*;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import repositorio.RepositorioCategoria;

/**
 *
 * @author Mauricio Capua
 */
public class Trabalho_Repository {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        listar();

        RepositorioCategoria repositoriocategoria = new RepositorioCategoria();
        //repositoriocaterogia.insert(new Categoria("novacategoria"));
        //repositoriocaterogia.delete_condicionado(JOptionPane.showInputDialog("Informe o id da categoria que deseja deletar: ", "id"));
        //repositoriocaterogia.selectLetraInicial(JOptionPane.showInputDialog("Informe a inicial do nome da categoria que deseja pesquisar: ", "Letra"));
        //repositoriocaterogia.update(new Categoria(Integer.parseInt(JOptionPane.showInputDialog("Informe o id da categoria que deseja alterar: ", "id")), (JOptionPane.showInputDialog("Informe o nome: ", "nome"))));

        RepositorioProduto repositorioproduto = new RepositorioProduto();
        /*repositorioproduto.insert(new Produto(
                JOptionPane.showInputDialog("Informe o nome"),
                Double.parseDouble(JOptionPane.showInputDialog("informe o valor: ")),
                Integer.parseInt(JOptionPane.showInputDialog("Informe o id da categoria: "))));*/
        
        //repositorioproduto.delete_condicionado(JOptionPane.showInputDialog("Informe o id do produto que deseja deletar: ", "id"));
        repositorioproduto.selectLetraInicial(JOptionPane.showInputDialog("Informe a inicial do nome do produto que deseja pesquisar: ", "Letra"));

        /*repositorioproduto.update(new Produto(
                Integer.parseInt(JOptionPane.showInputDialog("Informe o id da categoria que deseja alterar: ")),
                JOptionPane.showInputDialog("Informe o nome"),
                Double.parseDouble(JOptionPane.showInputDialog("informe o valor: ")),
                Integer.parseInt(JOptionPane.showInputDialog("Informe o id da categoria: "))));*/

        listar();
    }

    public static void listar() throws SQLException {
        Formatter formatter = new Formatter();
        System.out.println(formatter.format("%1s %30s %20s", "ID", " | Nome | ", "Produtos"));
        for (int i = 0; i < RepositorioCategoria.listarTodos().size(); i++) {
            Categoria.print(RepositorioCategoria.listarTodos().get(i));
            Categoria a = RepositorioCategoria.listarTodos().get(i);
            for (int j = 0; j < RepositorioCategoria.obterProdutos(a).size(); j++) {
                Produto.print(RepositorioCategoria.obterProdutos(a).get(j));
            }
            System.out.println("");
        }
        System.out.println("");
    }

}
