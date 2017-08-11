/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author iapereira
 */
public interface DAO<Modelo> {
    public boolean inserir(Modelo modelo) throws SQLException;
    public boolean deletar (int id) throws SQLException;
    public ArrayList<Modelo> listar() throws SQLException;
    
    
}
