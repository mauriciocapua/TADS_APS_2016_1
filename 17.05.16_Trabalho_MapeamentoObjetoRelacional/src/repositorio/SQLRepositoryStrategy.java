/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.List;
import repositorio.Query;

public class SQLRepositoryStrategy implements RepositorioStrategy {

    @Override
    public String matching(Query query) {
        List<Criteria> vetCriteria = query.getVetCriteria();
        String sql = " WHERE ";
        StringBuffer sqlbuf = new StringBuffer();
        for (int i = 0; i < vetCriteria.size(); i++) {
            Criteria criteria = vetCriteria.get(i);
            sqlbuf.append(" ").append(criteria.getField()).append(" ").append(criteria.getOperator()).append(" ").append(criteria.getValue().toString());
        }
        sql = sql + sqlbuf;
        return sql;
    }

}
