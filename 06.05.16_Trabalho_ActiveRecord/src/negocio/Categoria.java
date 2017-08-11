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
import java.util.Formatter;
import java.util.List;
import persistencia.Conexao;

/**
 *
 * @author Mauricio Capua
 */
public class Categoria {

    private int id;
    private String nome;
    private List<Produto> vetProdutos;

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Categoria() {
    }

    public Categoria(String nome, List<Produto> vetProdutos) {
        this.nome = nome;
        this.vetProdutos = vetProdutos;
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

    public List<Produto> getVetProdutos() {
        return vetProdutos;
    }

    public void setVetProdutos(List<Produto> vetProdutos) {
        this.vetProdutos = vetProdutos;
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

    public void carregar() throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "SELECT * FROM categoria WHERE id = ?";
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
        String sql = "INSERT INTO categoria (nome) VALUES (?) RETURNING id;";
        PreparedStatement sqlInsert = connection.prepareStatement(sql);
        sqlInsert.setString(1, this.nome);
        ResultSet rs = sqlInsert.executeQuery();
        if (rs.next()) {
            this.id = rs.getInt("id");
            System.out.println("Categoria com id: " + this.id + " salvo");
        }
        sqlInsert.close();
        connection.close();
    }

    public void excluir() throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "DELETE FROM categoria WHERE id = ?;";
        PreparedStatement sqlDelete = connection.prepareStatement(sql);
        sqlDelete.setInt(1, this.id);
        sqlDelete.executeUpdate();
        sqlDelete.close();
        connection.close();
    }

    public void alterar() throws SQLException {
        Categoria temp = new Categoria();
        temp.carregar();

        if (nome == null) {
            setNome(temp.getNome());
        }
        Connection connection = new Conexao().getConexao();
        String sql = "update categoria set nome = ? WHERE id =" + getId() + ";";
        PreparedStatement sqlUpdate = connection.prepareStatement(sql);
        sqlUpdate.setString(1, this.nome);
        sqlUpdate.executeUpdate();
        sqlUpdate.close();
        connection.close();
    }

    public void obterProdutos() throws SQLException {
        List<Produto> vetProdutos = new ArrayList();
        Connection connection = new Conexao().getConexao();
        String sql = "SELECT * FROM produto WHERE id_categoria = ?";
        PreparedStatement sqlSelect = connection.prepareStatement(sql);
        sqlSelect.setInt(1, this.id);
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
        this.setVetProdutos(vetProdutos);
    }

    public static void print(Categoria categoria) {
        Formatter formatter = new Formatter();
        System.out.print(formatter.format("%1s %35s", categoria.getId(), categoria.getNome()));

    }

}
