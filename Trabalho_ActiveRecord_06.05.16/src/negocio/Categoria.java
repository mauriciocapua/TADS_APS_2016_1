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
import persistencia.Conexao;

/**
 *
 * @author Mauricio Capua
 */
public class Categoria {

    private int id;
    private String nome;

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Categoria() {

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

    public static List<Categoria> listarTodos() throws SQLException {
        List<Categoria> vetCategoria = new ArrayList();
        Connection conexao = new Conexao().getConexao();
        String sql = "SELECT * FROM categorias";
        PreparedStatement sqlSelect = conexao.prepareStatement(sql);
        ResultSet rs = sqlSelect.executeQuery();
        Categoria categorias;
        while (rs.next()) {
            categorias = new Categoria();
            categorias.setId(rs.getInt("id"));
            categorias.setNome(rs.getString("nome"));
            vetCategoria.add(categorias);
        }
        sqlSelect.close();
        conexao.close();
        return vetCategoria;
    }

    public void carregar() throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "SELECT * FROM categorias WHERE id = ?";
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
        String sql = "INSERT INTO categorias (nome) VALUES (?) RETURNING id;";
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
        String sql = "DELETE FROM categorias WHERE id = ?;";
        PreparedStatement sqlDelete = connection.prepareStatement(sql);
        sqlDelete.setInt(1, this.id);
        sqlDelete.executeUpdate();
        sqlDelete.close();
        connection.close();
    }

}
