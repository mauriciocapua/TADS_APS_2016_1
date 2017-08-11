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
import modelo.Categoria;

public class CategoriaDAO implements DAO<Categoria> {

    public static List<Categoria> listarTodos() throws SQLException {
        List<Categoria> vetCategoria = new ArrayList();
        Connection connection = new Conexao().getConexao();
        String sql = "SELECT * FROM categoria";
        PreparedStatement sqlSelect = connection.prepareStatement(sql);
        ResultSet rs = sqlSelect.executeQuery();
        Categoria categoria;
        while (rs.next()) {
            categoria = new Categoria();
            categoria.setId(rs.getInt("id"));
            categoria.setNome(rs.getString("nome"));
            vetCategoria.add(categoria);
        }
        sqlSelect.close();
        connection.close();
        return vetCategoria;
    }

    public List<Categoria> select(String where) throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "SELECT * FROM categoria " + where;
        PreparedStatement sqlQuery = connection.prepareStatement(sql);
        ResultSet rs = sqlQuery.executeQuery();
        Categoria categoria;
        List<Categoria> listaCategoria = new ArrayList();
        while (rs.next()) {
            categoria = new Categoria();
            categoria.setId(rs.getInt("id"));
            categoria.setNome(rs.getString("nome"));
            listaCategoria.add(categoria);
        }
        sqlQuery.close();
        connection.close();
        return listaCategoria;
    }

    @Override
    public void insert(Categoria modelo) throws SQLException {
        Connection connection = new Conexao().getConexao();
        String tabela = modelo.getClass().getSimpleName().toLowerCase();
        String sql = "INSERT INTO " + tabela + " (nome) VALUES (?) RETURNING id;";
        PreparedStatement sqlInsert = connection.prepareStatement(sql);
        sqlInsert.setString(1, modelo.getNome());
        ResultSet rs = sqlInsert.executeQuery();
        if (rs.next()) {
            System.out.println("Categoria " + modelo.getNome() + " salvo com id: " + (rs.getInt("id")));
        }
        sqlInsert.close();
        connection.close();
    }

    @Override
    public void update(Categoria modelo) throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "update categoria set nome = (?) where id = (?) returning nome;";
        PreparedStatement sqlUpdate = connection.prepareStatement(sql);
        sqlUpdate.setString(1, modelo.getNome());
        sqlUpdate.setInt(2, modelo.getId());

        ResultSet rs = sqlUpdate.executeQuery();
        if (rs.next()) {
            System.out.println("Categoria com id: " + modelo.getId() + " Nome alterado " + (rs.getString("nome")));
        }
        //sqlUpdate.executeUpdate();
        sqlUpdate.close();
        connection.close();

    }

    @Override
    public void delete(Categoria modelo) throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "DELETE FROM categoria WHERE id = ?;";
        PreparedStatement sqlDelete = connection.prepareStatement(sql);
        sqlDelete.setInt(1, modelo.getId());
        sqlDelete.executeUpdate();
        sqlDelete.close();
        connection.close();
    }

    @Override
    public void delete_condicionado(String valor) throws SQLException {
        try (Connection connection = new Conexao().getConexao()) {
            String sql = "DELETE FROM categoria where id = " + valor + " ;";
            PreparedStatement sqlInsert = connection.prepareStatement(sql);
            sqlInsert.executeUpdate();
        }
    }

}
