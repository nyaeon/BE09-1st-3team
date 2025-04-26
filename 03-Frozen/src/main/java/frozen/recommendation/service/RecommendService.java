package frozen.recommendation.service;

import frozen.common.domain.Ingredients;
import frozen.common.domain.Recipe;
import frozen.recommendation.repository.RecommendRepository;

import java.sql.Connection;
import java.util.List;

import static frozen.common.JDBCTemplate.*;

public class RecommendService {

    private static RecommendRepository rr = new RecommendRepository();

    // 등록된 식재료 검색
    public List<Ingredients> searchIng(String userId) {

        Connection con = getConnection();
        List<Ingredients> result = rr.searchIng(con, userId);
        close(con);
        return result;
    }

    // 레시피 검색
    public Recipe searchRecipe(Recipe recipe) {

        Connection con = getConnection();
        Recipe result = rr.searchRecipe(con,recipe);
        close(con);
        return result;
    }

    // 관심 레시피 저장
    public static boolean saveRecipe(String recipeName) {

        Connection con = getConnection();
        boolean result = rr.saveRecipe(con, recipeName);
        if (result) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);
        return result;
    }
}
