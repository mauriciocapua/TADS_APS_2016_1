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
import javax.swing.JOptionPane;
import persistencia.*;

/**
 *
 * @author Mauricio Capua
 */
public class Produto {

    public static String ID = "id";
    public static String VALOR = "valor";
    public static String NOME = "nome";
    public static String ID_CATEGORIA = "id_categoria";

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

    public Produto(int id, String nome, double valor, int id_categoria) {;
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.id_categoria = id_categoria;
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

    public static void print(Produto produto) {
        Formatter formatter = new Formatter();
        System.out.print(formatter.format("%15s %10s %10s", "[id: " + produto.getId(), " | nome: " + produto.getNome(), " | valor: " + produto.getValor() + "]"));
    }

}
