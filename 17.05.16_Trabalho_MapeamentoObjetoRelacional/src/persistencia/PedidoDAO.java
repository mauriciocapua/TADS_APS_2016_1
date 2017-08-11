/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.*;

public class PedidoDAO implements DAO<Pedido> {

    public static List<Pedido> listarTodos() throws SQLException {
        List<Pedido> vetPedido = new ArrayList();
        Connection connection = new Conexao().getConexao();
        String sql = "select * from pedido";
        PreparedStatement sqlSelect = connection.prepareStatement(sql);
        ResultSet rs = sqlSelect.executeQuery();
        Pedido pedido;
        while (rs.next()) {
            pedido = new Pedido();
            pedido.setId(rs.getInt("id"));
            try {
                pedido.VetItensADD(ItemDAO.verifica_item(pedido.getId()));
            } catch (SQLException e) {

            }
            vetPedido.add(pedido);
        }
        sqlSelect.close();
        connection.close();

        return vetPedido;

    }

    public List<Pedido> select(String where) throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "SELECT * FROM Pedido " + where;
        PreparedStatement sqlQuery = connection.prepareStatement(sql);
        ResultSet rs = sqlQuery.executeQuery();
        Pedido pedido;
        List<Pedido> listaPedido = new ArrayList();
        while (rs.next()) {
            pedido = new Pedido();
            pedido.setId(rs.getInt("id"));

            listaPedido.add(pedido);
        }
        sqlQuery.close();
        connection.close();
        return listaPedido;
    }

    @Override
    public void insert(Pedido modelo) throws SQLException {
        Connection connection = new Conexao().getConexao();
        String tabela = modelo.getClass().getSimpleName().toLowerCase();
        String sql = "INSERT INTO " + tabela + " (nome) VALUES (?) RETURNING id;";
        PreparedStatement sqlInsert = connection.prepareStatement(sql);
        // sqlInsert.setString(1, modelo.getNome());
        ResultSet rs = sqlInsert.executeQuery();
        if (rs.next()) {
            //      System.out.println("Pedido " + modelo.getNome() + " salvo com id: " + (rs.getInt("id")));
        }
        sqlInsert.close();
        connection.close();
    }

    @Override
    public void update(Pedido modelo) throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "update pedido set nome = (?) where id = (?) returning nome;";
        PreparedStatement sqlUpdate = connection.prepareStatement(sql);
        //sqlUpdate.setString(1, modelo.getNome());
        sqlUpdate.setInt(2, modelo.getId());

        ResultSet rs = sqlUpdate.executeQuery();
        if (rs.next()) {
            System.out.println("Pedido com id: " + modelo.getId() + " Nome alterado " + (rs.getString("nome")));
        }
        //sqlUpdate.executeUpdate();
        sqlUpdate.close();
        connection.close();

    }

    @Override
    public void delete(Pedido modelo) throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "DELETE FROM pedido WHERE id = ?;";
        PreparedStatement sqlDelete = connection.prepareStatement(sql);
        sqlDelete.setInt(1, modelo.getId());
        sqlDelete.executeUpdate();
        sqlDelete.close();
        connection.close();
    }

    @Override
    public void delete_condicionado(String valor) throws SQLException {
        try (Connection connection = new Conexao().getConexao()) {
            String sql = "DELETE FROM pedido where id = " + valor + " ;";
            PreparedStatement sqlInsert = connection.prepareStatement(sql);
            sqlInsert.executeUpdate();
        }
    }

}
