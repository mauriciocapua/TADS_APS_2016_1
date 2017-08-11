/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Mauricio Capua
 */
public class Item {

    private int id;
    private int quantidade_livro;
    private Livro livro;
    private int id_pedido;

    public Item() {
    }

    public Item(int id, int quantidade_livro, Livro livro, int id_pedido) {
        this.id = id;
        this.quantidade_livro = quantidade_livro;
        this.livro = livro;
        this.id_pedido = id_pedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade_livro() {
        return quantidade_livro;
    }

    public void setQuantidade_livro(int quantidade_livro) {
        this.quantidade_livro = quantidade_livro;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

}
