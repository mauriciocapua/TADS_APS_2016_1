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
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.Conexao;

/**
 *
 * @author Mauricio Capua
 */
public class Twitter implements MSGSender {

    protected String msg;

    public Twitter(String msg) {
        this.msg = msg;
    }

    public Twitter() {

    }

    @Override
    public void send(String msg) {
        this.msg = msg;
        System.out.println(msg);
        try {
            salvar();
        } catch (SQLException ex) {
            Logger.getLogger(Twitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar() throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "INSERT INTO mensagem (texto) VALUES (?) RETURNING id;";
        PreparedStatement sqlInsert = connection.prepareStatement(sql);
        sqlInsert.setString(1, this.msg);
        ResultSet rs = sqlInsert.executeQuery();
        if (!(rs.next())) {
            // System.out.println("Categoria salvo com id: " + rs.getInt("id"));
            System.out.println("erro");
        }
        sqlInsert.close();
        connection.close();
    }
}
