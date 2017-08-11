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
import modelo.Livro;
import modelo.Livro;

/**
 *
 * @author Mauricio Capua
 */
public class LivroDAO implements DAO<Livro> {
    
    public static Livro verifica_livro(int id_livro) throws SQLException {
        Connection connection = new Conexao().getConexao();
        String sql = "SELECT * FROM Livro WHERE id = ?;";
        PreparedStatement sqlQuery = connection.prepareStatement(sql);
        ResultSet rs = sqlQuery.executeQuery();
        Livro livro = new Livro();
        while (rs.next()) {
            
            livro.setId(rs.getInt("id"));
            livro.setISBN(rs.getInt("ISBN"));
            
        }
        sqlQuery.close();
        connection.close();
        return livro;
    }
    
    @Override
    
    public void insert(Livro modelo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void update(Livro modelo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void delete(Livro modelo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void delete_condicionado(String where) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
