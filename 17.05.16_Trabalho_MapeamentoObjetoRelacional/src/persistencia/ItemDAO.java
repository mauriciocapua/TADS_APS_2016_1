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
import modelo.Pedido;
import modelo.*;

/**
 *
 * @author Mauricio Capua
 */
public class ItemDAO implements DAO<Item> {

    public static Item verifica_item(int id_item) throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "SELECT * FROM Item WHERE id = ?;";
        PreparedStatement sqlQuery = connection.prepareStatement(sql);
        ResultSet rs = sqlQuery.executeQuery();
        Item item = new Item();
        while (rs.next()) {

            item.setId(rs.getInt("id"));
            item.setLivro(LivroDAO.verifica_livro(rs.getInt("id_livro")));
            item.setQuantidade_livro(rs.getInt("quantidade"));
            item.setId_pedido(rs.getInt("id_pedido"));

        }
        sqlQuery.close();
        connection.close();
        return item;
    }

    @Override
    public void delete_condicionado(String where) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Item modelo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Item modelo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Item modelo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
