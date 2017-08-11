/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Produto;

public class ProdutoDAO implements DAO<Produto> {

    public static List<Produto> listarTodos() throws SQLException {
        List<Produto> vetProduto = new ArrayList();
        Connection connection = new Conexao().getConexao();
        String sql = "SELECT * FROM produto";
        PreparedStatement sqlSelect = connection.prepareStatement(sql);
        ResultSet rs = sqlSelect.executeQuery();
        Produto produto;
        while (rs.next()) {
            produto = new Produto();
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setValor(rs.getDouble("valor"));
            produto.setId_categoria(rs.getInt("id_categoria"));
            vetProduto.add(produto);
        }
        sqlSelect.close();
        connection.close();
        return vetProduto;
    }

    public List<Produto> select(String where) throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "SELECT * FROM produto " + where;
        PreparedStatement sqlQuery = connection.prepareStatement(sql);
        ResultSet rs = sqlQuery.executeQuery();
        Produto produto;
        List<Produto> listaProduto = new ArrayList();
        while (rs.next()) {
            produto = new Produto();
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setValor(rs.getDouble("valor"));
            produto.setId_categoria(rs.getInt("id_categoria"));
            listaProduto.add(produto);
        }
        sqlQuery.close();
        connection.close();
        return listaProduto;
    }

    @Override
    public void insert(Produto modelo) throws SQLException {
        Connection connection = new Conexao().getConexao();
        String tabela = modelo.getClass().getSimpleName().toLowerCase();
        String sql = "INSERT INTO " + tabela + " (nome, valor, id_categoria) VALUES (?,?,?) RETURNING id;";
        PreparedStatement sqlInsert = connection.prepareStatement(sql);
        sqlInsert.setString(1, modelo.getNome());
        sqlInsert.setDouble(2, modelo.getValor());
        sqlInsert.setInt(3, modelo.getId_categoria());
        ResultSet rs = sqlInsert.executeQuery();
        if (rs.next()) {
            modelo.setId(rs.getInt("id"));
            System.out.println("Produto com id: " + modelo.getId() + " salvo");
        }
        sqlInsert.close();
        connection.close();
    }

    @Override
    public void update(Produto modelo) throws SQLException {

        if (modelo.getNome() == null) {
            modelo.setNome(JOptionPane.showInputDialog("Valor vazio - informe um valor válido: ", ""));
        }
        if (modelo.getValor() < 0) {
            modelo.setValor(Double.parseDouble(JOptionPane.showInputDialog("Valor vazio - informe um valor válido: ", 0.0)));
        }
        Connection connection = new Conexao().getConexao();
        String sql = "update produto set nome = ?, valor = ?, id_categoria = ? WHERE id =" + modelo.getId() + ";";
        PreparedStatement sqlUpdate = connection.prepareStatement(sql);
        sqlUpdate.setString(1, modelo.getNome());
        sqlUpdate.setDouble(2, modelo.getValor());
        sqlUpdate.setInt(3, modelo.getId_categoria());
        try {
            sqlUpdate.executeUpdate();
        } catch (SQLException e) {

            modelo.setId_categoria(Integer.parseInt(JOptionPane.showInputDialog(e.getMessage(), "informe um id de categoria válido: ")));
            // setId_categoria();
            //sqlUpdate.close();
            //connection.close();
            // alterar();
        }
        sqlUpdate.close();
        connection.close();
    }

    @Override
    public void delete_condicionado(String valor) throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "DELETE FROM produto where id = " + valor + " ;";
        PreparedStatement sqlInsert = connection.prepareStatement(sql);
        sqlInsert.executeUpdate();
        connection.close();
    }

    @Override
    public void delete(Produto modelo) throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "DELETE FROM produto WHERE id = ?;";
        PreparedStatement sqlDelete = connection.prepareStatement(sql);
        sqlDelete.setInt(1, modelo.getId());
        sqlDelete.executeUpdate();
        sqlDelete.close();
        connection.close();
    }

}
