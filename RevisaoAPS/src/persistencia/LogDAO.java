/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.ArrayList;

/**
 *
 * @author Mauricio Capua
 */
public class LogDAO implements DAO{

    public boolean inserir(String log) throws SQLException {
       
        boolean resultado = false;
        Connection conexao = new Conexao().getConexao();
        PreparedStatement insert = conexao.prepareStatement("INSERT INTO log(pedidos, data) VALUES (?,?);");

        insert.setString(1, log);
        insert.setString(2, String.valueOf(ZonedDateTime.now()));



        if (insert.executeUpdate() == 1) {
            resultado = true;
        }
        conexao.close();
        return resultado;
    }
    
    
    
    
    
    
    
    

    @Override
    public boolean deletar(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean inserir(Object modelo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

