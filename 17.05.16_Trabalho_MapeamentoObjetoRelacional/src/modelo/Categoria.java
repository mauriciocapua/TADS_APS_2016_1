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
public class Categoria {

    public static String ID = "id";
    public static String NOME = "nome";

    private int id;
    private String nome;
    private List<Produto> vetProdutos;

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Categoria() {
    }

    public Categoria(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Categoria(int id, String nome, List<Produto> vetProdutos) {
        this.id = id;
        this.nome = nome;
        this.vetProdutos = vetProdutos;
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

    public static void print(Categoria categoria) {
        Formatter formatter = new Formatter();
        System.out.print(formatter.format("%1s %35s", categoria.getId(), categoria.getNome()));

    }

}
