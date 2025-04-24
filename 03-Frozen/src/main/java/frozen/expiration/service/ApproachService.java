package frozen.expiration.service;

import frozen.common.domain.Ingredients;
import frozen.expiration.repository.ApproachRepository;

import java.sql.Connection;
import java.util.List;

import static frozen.common.JDBCTemplate.*;

public class ApproachService {

    private final ApproachRepository appRepository = new ApproachRepository();

    public List<Ingredients> searchApp(Ingredients ing) {

        Connection con = getConnection();
        List<Ingredients> result = appRepository.searchApp(con,ing);
        close(con);
        return result;
    }
}
