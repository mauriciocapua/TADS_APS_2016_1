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
import javax.swing.JOptionPane;
import persistencia.*;

/**
 *
 * @author Mauricio Capua
 */
public class Produto {

    private int id;
    private String nome;
    private double valor;
    private int id_categoria;

    public Produto(String nome, double valor, int id_categoria) {;
        this.nome = nome;
        this.valor = valor;
        this.id_categoria = id_categoria;
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

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
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
            this.setValor(rs.getDouble("valor"));
            this.setId_categoria(rs.getInt("id_categoria"));
        }
        sqlSelect.close();
        connection.close();
    }

    public void salvar() throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "INSERT INTO produto (nome, valor, id_categoria) VALUES (?, ?, ?) RETURNING id;";
        PreparedStatement sqlInsert = connection.prepareStatement(sql);
        sqlInsert.setString(1, this.nome);
        sqlInsert.setDouble(2, (this.valor));
        sqlInsert.setInt(3, this.id_categoria);
        ResultSet rs = sqlInsert.executeQuery();
        if (rs.next()) {
            this.id = rs.getInt("id");
            System.out.println("Produto com id: " + this.id + " salvo");
        }
        sqlInsert.close();
        connection.close();
    }

    public void alterar() throws SQLException {
        Produto temp = new Produto();
        temp.carregar();

        if (nome == null) {
            setNome(temp.getNome());
        }
        if (valor < 0) {
            setValor(Double.parseDouble(JOptionPane.showInputDialog("Valor vazio - informe um valor válido: ", 0.0)));
        }
        Connection connection = new Conexao().getConexao();
        String sql = "update produto set nome = ?, valor = ?, id_categoria = ? WHERE id =" + getId() + ";";
        PreparedStatement sqlUpdate = connection.prepareStatement(sql);
        sqlUpdate.setString(1, this.nome);
        sqlUpdate.setDouble(2, this.valor);
        sqlUpdate.setInt(3, this.id_categoria);
        try {
            sqlUpdate.executeUpdate();
        } catch (SQLException e) {

            setId_categoria(temp.getId_categoria());
            // setId_categoria(Integer.parseInt(JOptionPane.showInputDialog(e.getMessage(), "informe um id de categoria válido: ")));
            //sqlUpdate.close();
            //connection.close();
            // alterar();
        }
        sqlUpdate.close();
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

    public static void print(Produto produto) {
        Formatter formatter = new Formatter();
        System.out.print(formatter.format("%15s %10s %10s", "[id: " + produto.getId(), " | nome: " + produto.getNome(), " | valor: " + produto.getValor() + "]"));
    }

}
