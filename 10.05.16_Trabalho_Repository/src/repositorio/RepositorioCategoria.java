/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;
import modelo.Produto;
import persistencia.CategoriaDAO;
import persistencia.Conexao;

public class RepositorioCategoria implements Repositorio_interface<Categoria> {

    private RepositorioStrategy strategy;
    private CategoriaDAO dao;

    public RepositorioCategoria() {
        this.strategy = new SQLRepositoryStrategy();
        this.dao = new CategoriaDAO();
    }

    public List<Categoria> selecionarTodos() throws SQLException {
        return dao.listarTodos();
    }

    public static void mostrarTodos(List<Categoria> listaCategoria) throws SQLException {
        for (Categoria aux : listaCategoria) {
            System.out.print("Id:" + aux.getId());
            System.out.print(" Nome:" + aux.getNome());
            System.out.println("");
        }
        System.out.println("");
    }

    public static List<Categoria> listarTodos() throws SQLException {
        List<Categoria> vetCategoria = new ArrayList();
        Connection conexao = new Conexao().getConexao();
        String sql = "SELECT * FROM categoria";
        PreparedStatement sqlSelect = conexao.prepareStatement(sql);
        ResultSet rs = sqlSelect.executeQuery();
        Categoria categoria;
        while (rs.next()) {
            categoria = new Categoria();
            categoria.setId(rs.getInt("id"));
            categoria.setNome(rs.getString("nome"));
            vetCategoria.add(categoria);
        }
        sqlSelect.close();
        conexao.close();
        return vetCategoria;
    }

    public static List<Produto> obterProdutos(Categoria categoria) throws SQLException {
        List<Produto> vetProdutos = new ArrayList();
        Connection connection = new Conexao().getConexao();
        String sql = "SELECT * FROM produto WHERE id_categoria = ?";
        PreparedStatement sqlSelect = connection.prepareStatement(sql);
        sqlSelect.setInt(1, categoria.getId());
        ResultSet rs = sqlSelect.executeQuery();
        Produto produto;
        while (rs.next()) {
            produto = new Produto();
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setValor(rs.getDouble("valor"));
            vetProdutos.add(produto);
        }
        sqlSelect.close();
        connection.close();
        return vetProdutos;
    }

    public void selectLetraInicial(String valor) throws SQLException {
        Query q = new Query();
        q.addCriteria(new Criteria(Operador.ILIKE, Categoria.NOME, "'" + valor + "%'"));
        String sql = this.strategy.matching(q);
        mostrarTodos(dao.select(sql));
    }

    @Override
    public void insert(Categoria modelo) throws SQLException {
        dao.insert(modelo);
    }

    @Override
    public void update(Categoria modelo) throws SQLException {
        dao.update(modelo);
    }

    @Override
    public void delete(Categoria modelo) throws SQLException {
        dao.delete(modelo);
    }

    public void delete_condicionado(String valor) throws SQLException {
        dao.delete_condicionado(valor);
    }

}
