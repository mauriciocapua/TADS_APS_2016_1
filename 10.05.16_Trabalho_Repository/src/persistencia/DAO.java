/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.SQLException;
import modelo.Produto;

/**
 *
 * @author Enki
 */
interface DAO<Modelo> {

    void insert(Modelo modelo) throws SQLException;

    void update(Modelo modelo) throws SQLException;

    void delete(Modelo modelo) throws SQLException;

    void delete_condicionado(String where) throws SQLException;

}
