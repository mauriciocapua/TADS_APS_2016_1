/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdk.nashorn.internal.runtime.regexp.joni.EncodingHelper;
import persistencia.Conexao;

/**
 *
 * @author Mauricio Capua
 */
public class Item {

    private int quantidade;
    private Livro livro;
    private Pedido pedido;

    public Item() {
    }

    public Item(int quantidade, Pedido pedido, Livro livro) {

        this.quantidade = quantidade;
        this.livro = livro;
        this.pedido = pedido;
    }

    public Item(int quantidade, Livro livro) {

        this.quantidade = quantidade;
        this.livro = livro;

    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public static List<Item> verifica_item(int id_pedido) throws SQLException {
        List<Item> vetItem = new ArrayList();
        Connection connection = new Conexao().getConexao();
        String sql = "SELECT * FROM item WHERE id_pedido = ?";
        PreparedStatement sqlSelect = connection.prepareStatement(sql);
        sqlSelect.setInt(1, id_pedido);
        ResultSet rs = sqlSelect.executeQuery();
        Item item;
        while (rs.next()) {
            item = new Item();
            item.setLivro(Livro.verifica_livro(rs.getInt("isbn_livro")));
            item.setQuantidade(rs.getInt("quantidade"));
            item.setPedido(Pedido.verifica_pedido(rs.getInt("id_pedido")));
            vetItem.add(item);
        }

        sqlSelect.close();
        connection.close();
        return vetItem;
    }

    public void carregar() throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "SELECT * FROM item WHERE id = ?";
        PreparedStatement sqlSelect = connection.prepareStatement(sql);
        sqlSelect.setInt(1, this.pedido.getId());
        ResultSet rs = sqlSelect.executeQuery();
        if (rs.next()) {

            this.pedido.setId(rs.getInt("id_pedido"));
            this.setLivro(Livro.verifica_livro(rs.getInt("isbn_livro")));
            this.setQuantidade(rs.getInt("quantidade"));
        }
        sqlSelect.close();
        connection.close();
    }

    public void salvaritem() throws SQLException {
        Connection connection = new Conexao().getConexao();
        // try {
        String sql = "INSERT INTO item (quantidade, id_pedido, isbn_livro) VALUES (?,?,?) returning id_pedido";
        PreparedStatement sqlInsert = connection.prepareStatement(sql);
        sqlInsert.setInt(1, this.quantidade);
        sqlInsert.setInt(2, this.pedido.getId());
        sqlInsert.setInt(3, this.livro.getISBN());
        ResultSet rs = sqlInsert.executeQuery();
        if (rs.next()) {

            System.out.println("salvo");
        }

        sqlInsert.close();
        connection.close();
        //   } catch (Exception e) {
        //      System.out.println("Sem itens para salvar");
        //  }
    }

    public void excluir() throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "DELETE FROM item WHERE id_pedido = ?;";
        PreparedStatement sqlDelete = connection.prepareStatement(sql);
        sqlDelete.setInt(1, this.pedido.getId());
        sqlDelete.executeUpdate();
        sqlDelete.close();
        connection.close();
    }

    public void alterar() throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "update item set quantidade = ? WHERE id_pedido =" + pedido.getId() + ";";
        PreparedStatement sqlUpdate = connection.prepareStatement(sql);
        sqlUpdate.setInt(1, this.quantidade);
        sqlUpdate.executeUpdate();
        sqlUpdate.close();
        connection.close();
    }

    @Override
    public String toString() {
        return "ITEM{quantidade=" + quantidade + ", LIVRO=" + livro.toString() + ", id_pedido=" + pedido.getId() + '}';
    }

}
