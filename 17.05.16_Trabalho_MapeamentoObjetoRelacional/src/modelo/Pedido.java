/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Collection;
import java.util.Formatter;

/**
 *
 * @author Mauricio Capua
 */
public class Pedido {

    private int id;
    private Collection<Item> vetItens;

    public Pedido(int id, Collection<Item> vetItens) {
        this.id = id;
        this.vetItens = vetItens;
    }

    public Pedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<Item> getVetItens() {
        return vetItens;
    }

    public void setVetItens(Collection<Item> vetItens) {
        this.vetItens = vetItens;
    }

    public void VetItensADD(Item item) {
        vetItens.add(item);
    }

}
