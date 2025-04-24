package frozen.recommendation.service;

import frozen.common.domain.Ingredients;
import frozen.common.domain.Recipe;
import frozen.recommendation.repository.RecommendRepository;

import java.sql.Connection;
import java.util.List;

import static frozen.common.JDBCTemplate.close;
import static frozen.common.JDBCTemplate.getConnection;

public class RecommendService {

    private RecommendRepository rr = new RecommendRepository();

    public List<Ingredients> searchIng(Ingredients ing) {

        Connection con = getConnection();
        List<Ingredients> result = rr.searchIng(con, ing);
        close(con);
        return result;
    }

    public boolean searchExist(Ingredients ing) {

        boolean result = false;

        Connection con = getConnection();
        result = rr.searchExist(con, ing);
        close(con);

        return result;
    }

    public Recipe searchRecipe(Recipe recipe) {

        Connection con = getConnection();
        Recipe result = rr.searchRecipe(con,recipe);
        close(con);
        return result;
    }
}
