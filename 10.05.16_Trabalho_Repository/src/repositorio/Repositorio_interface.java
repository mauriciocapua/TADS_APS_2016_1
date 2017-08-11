/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.sql.SQLException;

/**
 *
 * @author iapereira
 */
interface Repositorio_interface<Modelo> {

    void insert(Modelo modelo) throws SQLException;

    void update(Modelo modelo) throws SQLException;

    void delete(Modelo modelo) throws SQLException;
}
