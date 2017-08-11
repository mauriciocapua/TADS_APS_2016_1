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
import modelo.Pedido;
import modelo.Produto;
import persistencia.PedidoDAO;
import persistencia.Conexao;

public class RepositorioPedido implements Repositorio_interface<Pedido> {

    private RepositorioStrategy strategy;
    private PedidoDAO dao;

    public RepositorioPedido() {
        this.strategy = new SQLRepositoryStrategy();
        this.dao = new PedidoDAO();
    }

    public List<Pedido> selecionarTodos() throws SQLException {
        return dao.listarTodos();
    }

    public static void mostrarTodos(List<Pedido> listaPedido) throws SQLException {
        for (Pedido aux : listaPedido) {
            System.out.print("Id:" + aux.getId());
            System.out.print(" Itens:" + aux.getVetItens().toString());
            System.out.println("");
        }
        System.out.println("");
    }

    public static List<Pedido> listarTodos() throws SQLException {
        List<Pedido> vetPedido = new ArrayList();
        Connection conexao = new Conexao().getConexao();
        String sql = "SELECT * FROM pedido";
        PreparedStatement sqlSelect = conexao.prepareStatement(sql);
        ResultSet rs = sqlSelect.executeQuery();
        Pedido pedido;
        while (rs.next()) {
            pedido = new Pedido();
            pedido.setId(rs.getInt("id"));
            //   pedido.VetItensADD(rs.getInt("nome"));
            vetPedido.add(pedido);
        }
        sqlSelect.close();
        conexao.close();
        return vetPedido;
    }

    public static List<Produto> obterProdutos(Pedido pedido) throws SQLException {
        List<Produto> vetProdutos = new ArrayList();
        Connection connection = new Conexao().getConexao();
        String sql = "SELECT * FROM produto WHERE id_pedido = ?";
        PreparedStatement sqlSelect = connection.prepareStatement(sql);
        sqlSelect.setInt(1, pedido.getId());
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

    @Override
    public void insert(Pedido modelo) throws SQLException {
        dao.insert(modelo);
    }

    @Override
    public void update(Pedido modelo) throws SQLException {
        dao.update(modelo);
    }

    @Override
    public void delete(Pedido modelo) throws SQLException {
        dao.delete(modelo);
    }

    public void delete_condicionado(String valor) throws SQLException {
        dao.delete_condicionado(valor);
    }

}
