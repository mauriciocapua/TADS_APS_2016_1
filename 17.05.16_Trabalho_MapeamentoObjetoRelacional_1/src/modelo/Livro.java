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
import java.util.Formatter;
import java.util.List;
import persistencia.Conexao;

/**
 *
 * @author Mauricio Capua
 */
public class Livro {

    private String titulo;
    private int ISBN;

    public Livro() {
    }

    public Livro(String titulo, int ISBN) {

        this.titulo = titulo;
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public static List<Livro> listarTodosLivros() throws SQLException {
        List<Livro> vetLivros = new ArrayList();
        Connection connection = new Conexao().getConexao();
        String sql = "SELECT * FROM livro";
        PreparedStatement sqlSelect = connection.prepareStatement(sql);
        ResultSet rs = sqlSelect.executeQuery();
        Livro livro;
        while (rs.next()) {
            livro = new Livro();
            livro.setISBN(rs.getInt("isbn"));
            livro.setTitulo(rs.getString("titulo"));
            print(livro);
            vetLivros.add(livro);
        }
        sqlSelect.close();
        connection.close();
        return vetLivros;
    }

    public static Livro verifica_livro(int id_livro) throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "SELECT * FROM livro WHERE isbn = ?";
        PreparedStatement sqlSelect = connection.prepareStatement(sql);
        sqlSelect.setInt(1, id_livro);
        ResultSet rs = sqlSelect.executeQuery();
        Livro livro = null;
        while (rs.next()) {
            livro = new Livro();
            livro.setTitulo(rs.getString("titulo"));
            livro.setISBN(rs.getInt("isbn"));

        }
        sqlSelect.close();
        connection.close();
        return livro;
    }

    public void carregar() throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "SELECT * FROM livro WHERE isbn = ?";
        PreparedStatement sqlSelect = connection.prepareStatement(sql);
        sqlSelect.setInt(1, this.ISBN);
        ResultSet rs = sqlSelect.executeQuery();
        if (rs.next()) {

            this.setTitulo(rs.getString("titulo"));
        }
        sqlSelect.close();
        connection.close();
    }

    public void salvar() throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "INSERT INTO livro (isbn, titulo) VALUES (?,?) returning isbn";
        PreparedStatement sqlInsert = connection.prepareStatement(sql);
        sqlInsert.setInt(1, this.ISBN);
        sqlInsert.setString(2, this.titulo);
        ResultSet rs = sqlInsert.executeQuery();
        if (rs.next()) {
            System.out.println("Livro salvo");
        }
        sqlInsert.close();
        connection.close();
    }

    public void excluir() throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "DELETE FROM livro WHERE isbn = ?;";
        PreparedStatement sqlDelete = connection.prepareStatement(sql);
        sqlDelete.setInt(1, this.ISBN);
        sqlDelete.executeUpdate();
        sqlDelete.close();
        connection.close();
    }

    public void alterar() throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "update livro set titulo = ? WHERE isbn =" + getISBN() + ";";
        PreparedStatement sqlUpdate = connection.prepareStatement(sql);
        sqlUpdate.setString(1, this.titulo);
        sqlUpdate.executeUpdate();
        sqlUpdate.close();
        connection.close();
    }

    @Override
    public String toString() {
        return "Livro{" + "titulo=" + titulo + ", ISBN=" + ISBN + '}';
    }

    public static void print(Livro livro) {
        Formatter formatter = new Formatter();
        String aux = "";
        System.out.println(formatter.format("%1s, %15s", livro.getISBN(), livro.getTitulo()));

    }

}
