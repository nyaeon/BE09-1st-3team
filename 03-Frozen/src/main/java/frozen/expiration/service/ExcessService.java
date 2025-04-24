package frozen.expiration.service;

import frozen.common.domain.Ingredients;
import frozen.expiration.repository.ExcessRepository;

import java.sql.Connection;
import java.util.List;

import static frozen.common.JDBCTemplate.close;
import static frozen.common.JDBCTemplate.getConnection;

public class ExcessService {

    private final ExcessRepository excRepository = new ExcessRepository();

    public List<Ingredients> searchExc(Ingredients ing) {

        Connection con = getConnection();
        List<Ingredients> result = excRepository.searchExc(con, ing);
        close(con);
        return result;
    }
}
