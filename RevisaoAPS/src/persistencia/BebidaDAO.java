/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Bebida;

/**
 *
 * @author iapereira
 */
public class BebidaDAO implements DAO<Bebida>{

    /**
     *
     * @return
     * @throws SQLException
     */
 
    public ArrayList<Bebida> listar() throws SQLException {
        Connection conexao = new Conexao().getConexao();
        ArrayList<Bebida> vetBebida = new ArrayList();
        ResultSet resultSet = conexao.prepareStatement("SELECT * FROM bebida; ").executeQuery();
        Bebida bebida;
        while (resultSet.next()) {
            bebida = new Bebida();
            bebida.setId(resultSet.getInt("id"));
            bebida.setMarca(resultSet.getString("marca"));
            bebida.setPreco(resultSet.getDouble("preco"));

            vetBebida.add(bebida);
        }
        conexao.close();
        return vetBebida;
    }

    public boolean inserir(Bebida bebida) throws SQLException {
        boolean resultado = false;
        Connection conexao = new Conexao().getConexao();
        PreparedStatement insert = conexao.prepareStatement("INSERT INTO bebida(marca, volume, preco, tipo) VALUES (?, ?, ?, ?);");

        insert.setString(1, bebida.getMarca());

        insert.setDouble(3, bebida.getPreco());


        if (insert.executeUpdate() == 1) {
            resultado = true;
        }
        conexao.close();
        return resultado;
    }

    public boolean deletar(int id) throws SQLException {
        boolean resultado = false;
        Connection conexao = new Conexao().getConexao();
        PreparedStatement deletar = conexao.prepareStatement("DELETE FROM bebida WHERE id = ?;");
        deletar.setInt(1, id);
        if (deletar.executeUpdate() == 1) {
            resultado = true;
        }
        conexao.close();
        return resultado;
    }

}
