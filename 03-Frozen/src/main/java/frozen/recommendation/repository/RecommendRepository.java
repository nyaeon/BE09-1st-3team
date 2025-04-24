package frozen.recommendation.repository;

import frozen.common.domain.Ingredients;
import frozen.common.domain.Recipe;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static frozen.common.JDBCTemplate.close;

public class RecommendRepository {

    private final Properties prop;

    public RecommendRepository() {
        prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/frozen/mapper/RecommendMapper.xml"));
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Ingredients> searchIng(Connection con, Ingredients ing) {
        List<Ingredients> ingList = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = prop.getProperty("searchIngredients");

        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Ingredients resultIng = new Ingredients();
                resultIng.setName(rs.getString("name"));
                resultIng.setAmount(rs.getInt("amount"));
                resultIng.setExpDate(rs.getDate("expDate").toLocalDate());
                resultIng.setLocation(rs.getString("location"));

                int num = (int) ChronoUnit.DAYS.between(LocalDate.now(), resultIng.getExpDate());

                // 유통기한이 지나지 않은 재료들의 목록을 출력
                if(num > 0){
                    ingList.add(resultIng);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rs);
            close(pstmt);
        }

        return ingList;
    }

    public boolean searchExist(Connection con, Ingredients ing) {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = prop.getProperty("searchExistIngredients");
        boolean result = false;

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ing.getName());
            rs = pstmt.executeQuery();

            if (rs.next()) {
                result = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rs);
            close(pstmt);
        }
        return result;
    }

    public Recipe searchRecipe(Connection con, Recipe recipe) {
        Recipe resultRecipe = new Recipe();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = prop.getProperty("searchRecommendRecipe");

        String temp = recipe.getIngredients().replace("[", "").replace("]", "");
        String[] ingredients = temp.split(", ");

        try {
            pstmt = con.prepareStatement(sql);
            for (int i = 0; i < 3; i++) {
                if (!ingredients[i].equalsIgnoreCase("null")) {
                    pstmt.setString(i + 1, "%" + ingredients[i] + "%");
                } else {
                    pstmt.setString(i + 1, "%");
                }
            }
            rs = pstmt.executeQuery();

            if (rs.next()) {
                resultRecipe.setName(rs.getString("name"));
                resultRecipe.setIngredients(rs.getString("ingredients"));
                resultRecipe.setMethod(rs.getString("method"));
                resultRecipe.setTime(rs.getString("time"));
                resultRecipe.setLevel(rs.getInt("level"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rs);
            close(pstmt);
        }
        return resultRecipe;
    }
}
