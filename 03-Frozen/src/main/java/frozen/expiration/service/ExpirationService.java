package frozen.expiration.service;

import frozen.common.domain.Ingredients;
import frozen.expiration.repository.ExpirationRepository;

import java.sql.Connection;
import java.util.List;

import static frozen.common.JDBCTemplate.close;
import static frozen.common.JDBCTemplate.getConnection;

public class ExpirationService {

    private static final ExpirationRepository expRepository = new ExpirationRepository();

    // 유통기한 임박 재료 조회
    public static List<Ingredients> searchApp(Ingredients ing, String userId) {

        Connection con = getConnection();
        List<Ingredients> result = expRepository.searchApp(con, ing, userId);
        close(con);
        return result;
    }

    public static List<Ingredients> searchExc(Ingredients ing, String userId) {

        Connection con = getConnection();
        List<Ingredients> result = expRepository.searchExc(con, ing, userId);
        close(con);
        return result;
    }
}
