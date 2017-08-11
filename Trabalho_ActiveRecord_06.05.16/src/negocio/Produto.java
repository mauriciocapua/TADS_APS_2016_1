/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.*;

/**
 *
 * @author Mauricio Capua
 */
public class Produto {

    private int id;
    private String nome;
    private double valor;

    public Produto(String nome, double valor) {;
        this.nome = nome;
        this.valor = valor;
    }

    public Produto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

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
            vetProduto.add(produto);
        }
        sqlSelect.close();
        connection.close();
        return vetProduto;
    }

    public void carregar() throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "SELECT * FROM produto WHERE id = ?";
        PreparedStatement sqlSelect = connection.prepareStatement(sql);
        sqlSelect.setInt(1, this.id);
        ResultSet rs = sqlSelect.executeQuery();
        if (rs.next()) {
            this.setId(rs.getInt("id"));
            this.setNome(rs.getString("nome"));
        }
        sqlSelect.close();
        connection.close();
    }

    public void salvar() throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "INSERT INTO produto (nome) VALUES (?) RETURNING id;";
        PreparedStatement sqlInsert = connection.prepareStatement(sql);
        sqlInsert.setString(1, this.nome);
        ResultSet rs = sqlInsert.executeQuery();
        if (rs.next()) {
            this.id = rs.getInt("id");
        }
        sqlInsert.close();
        connection.close();
    }

    public void excluir() throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "DELETE FROM produto WHERE id = ?;";
        PreparedStatement sqlDelete = connection.prepareStatement(sql);
        sqlDelete.setInt(1, this.id);
        sqlDelete.executeUpdate();
        sqlDelete.close();
        connection.close();
    }

}
