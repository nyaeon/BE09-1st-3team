package frozen.expiration.service;

import frozen.common.domain.Ingredients;
import frozen.expiration.repository.ApproachRepository;

import java.sql.Connection;
import java.util.List;

import static frozen.common.JDBCTemplate.*;

public class ApproachService {

    private final ApproachRepository appRepository = new ApproachRepository();

    // 유통기한 임박 재료 조회
    public List<Ingredients> searchApp(Ingredients ing, String userId) {

        Connection con = getConnection();
        List<Ingredients> result = appRepository.searchApp(con, ing, userId);
        close(con);
        return result;
    }
}
