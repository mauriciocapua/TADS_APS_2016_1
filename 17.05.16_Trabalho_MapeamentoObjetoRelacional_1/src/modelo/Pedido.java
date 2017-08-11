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
import java.util.Collection;
import java.util.Formatter;
import java.util.List;
import persistencia.Conexao;

/**
 *
 * @author Mauricio Capua
 */
public class Pedido {

    private int id;
    private ArrayList<Item> vetItens;

    public Pedido(int id, ArrayList<Item> vetItens) {
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

    public List<Item> getVetItens() {
        return vetItens;
    }

    public void setVetItens(ArrayList<Item> vetItens) {
        this.vetItens = vetItens;
    }

    public void VetItensADD(Item item) {
        vetItens.add(item);
    }

    public static List<Pedido> listarTodos() throws SQLException {
        List<Pedido> vetPedido = new ArrayList();
        Connection conexao = new Conexao().getConexao();
        String sql = "SELECT * FROM pedido";
        PreparedStatement sqlSelect = conexao.prepareStatement(sql);
        ResultSet rs = sqlSelect.executeQuery();
        Pedido pedido;
        while (rs.next()) {
            pedido = new Pedido();
            pedido.setId(rs.getInt("id"));
            if (Item.verifica_item(pedido.getId()) != null) {
                pedido.setVetItens((ArrayList<Item>) Item.verifica_item(pedido.getId()));
            }
            vetPedido.add(pedido);
        }
        sqlSelect.close();
        conexao.close();
        return vetPedido;
    }

    public void carregar() throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "SELECT * FROM pedido WHERE id = ?";
        PreparedStatement sqlSelect = connection.prepareStatement(sql);
        sqlSelect.setInt(1, this.id);
        ResultSet rs = sqlSelect.executeQuery();
        if (rs.next()) {
            if (Item.verifica_item(getId()) != null) {
                setVetItens((ArrayList<Item>) Item.verifica_item(getId()));
            }
        }
        sqlSelect.close();
        connection.close();
    }

    public void salvar() throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "INSERT INTO pedido (id) VALUES (?) RETURNING id;";
        PreparedStatement sqlInsert = connection.prepareStatement(sql);
        sqlInsert.setInt(1, this.id);
        ResultSet rs = sqlInsert.executeQuery();
        if (rs.next()) {
            this.id = rs.getInt("id");
            System.out.println("Pedido com id: " + this.id + " salvo");
            // try {
            Item item;
            for (int i = 0; i < getVetItens().size(); i++) {

                getVetItens().get(i);
                getVetItens().get(i).getPedido().setId(getId());
                getVetItens().get(i).salvaritem();
            }
            // } catch (Exception e) {
            //   System.out.println("não deu");
            //}
        }

        sqlInsert.close();

        connection.close();
    }

    public void excluir() throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "DELETE FROM pedido WHERE id = ?;";
        PreparedStatement sqlDelete = connection.prepareStatement(sql);
        sqlDelete.setInt(1, this.id);
        sqlDelete.executeUpdate();
        sqlDelete.close();
        connection.close();
    }

    public static Pedido verifica_pedido(int id_pedido) throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "SELECT * FROM pedido WHERE id = ?";
        PreparedStatement sqlSelect = connection.prepareStatement(sql);
        sqlSelect.setInt(1, id_pedido);
        ResultSet rs = sqlSelect.executeQuery();
        Pedido pedido = null;
        while (rs.next()) {
            pedido = new Pedido();
            pedido.setId(rs.getInt("id"));
        }
        sqlSelect.close();
        connection.close();
        return pedido;
    }

    /*public void alterar() throws SQLException {      
        Connection connection = new Conexao().getConexao();
        String sql = "update pedido set nome = ? WHERE id =" + getId() + ";";
        PreparedStatement sqlUpdate = connection.prepareStatement(sql);
        sqlUpdate.setString(1, this.nome);
        sqlUpdate.executeUpdate();
        sqlUpdate.close();
        connection.close();
    }*/
    public static void print(Pedido pedido) {
        Formatter formatter = new Formatter();
        String aux = "";
        for (int i = 0; i < pedido.getVetItens().size(); i++) {
            aux += "\n" + pedido.getVetItens().get(i).toString();
        }
        System.out.println(formatter.format("%1s, %35s", pedido.getId(), aux));

    }

}
