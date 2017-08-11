/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import modelo.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;
import persistencia.ProdutoDAO;
import static repositorio.RepositorioPedido.mostrarTodos;

public class RepositorioProduto implements Repositorio_interface<Produto> {

    private RepositorioStrategy strategy;
    private ProdutoDAO dao;

    public RepositorioProduto() {
        this.strategy = new SQLRepositoryStrategy();
        this.dao = new ProdutoDAO();
    }

    public List<Produto> selecionarTodos() throws SQLException {
        return dao.listarTodos();
    }

    public static void mostrarTodos(List<Produto> listaProduto) throws SQLException {
        for (Produto aux : listaProduto) {
            System.out.print("Id:" + aux.getId());
            System.out.print(" Nome:" + aux.getNome());
            System.out.print(" Valor:" + aux.getValor());
            System.out.println(" Id_categoria:" + aux.getId_categoria());
        }
        System.out.println("");
    }

    public void selectLetraInicial(String valor) throws SQLException {
        Query q = new Query();
        q.addCriteria(new Criteria(Operador.ILIKE, Produto.NOME, "'" + valor + "%'"));
        String sql = this.strategy.matching(q);
        mostrarTodos(dao.select(sql));
    }

    public void select(String where) throws SQLException {
        dao.select(where);
    }

    @Override
    public void insert(Produto modelo) throws SQLException {
        dao.insert(modelo);
    }

    @Override
    public void update(Produto modelo) throws SQLException {
        dao.update(modelo);
    }

    @Override
    public void delete(Produto modelo) throws SQLException {
        dao.delete(modelo);
    }

    public void delete_condicionado(String valor) throws SQLException {
        dao.delete_condicionado(valor);
    }

}
