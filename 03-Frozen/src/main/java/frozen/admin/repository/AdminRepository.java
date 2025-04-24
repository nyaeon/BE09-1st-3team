package frozen.admin.repository;

import frozen.admin.dto.AdminDTO;

import java.sql.Connection;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static frozen.common.JDBCTemplate.close;

public class AdminRepository {

    private List<AdminDTO> recipes;

    private Properties prop;

    public AdminRepository(){
        prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/frozen/mapper/AdminMapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public int insertRecipe(Connection con, AdminDTO recipe) {
        int result = 0;
        PreparedStatement pstmt = null;
        String query = prop.getProperty("insertRecipe");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, recipe.getMenuName());
            pstmt.setString(2, recipe.getIngredients());
            pstmt.setString(3, recipe.getMethod());
            pstmt.setString(4, recipe.getTime());
            pstmt.setInt(5, recipe.getLevel());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }


    public List<AdminDTO> selectAllRecipes(Connection con) {

        List<AdminDTO> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String query = prop.getProperty("selectRecipe");

        try {
            pstmt = con.prepareStatement(query);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                AdminDTO recipe = new AdminDTO();
                recipe.setMenuName(rset.getString("name"));
                recipe.setIngredients(rset.getString("ingredients"));
                recipe.setMethod(rset.getString("method"));
                recipe.setTime(rset.getString("time"));
                recipe.setLevel(rset.getInt("level"));
                list.add(recipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }

        return list;
    }

    public AdminDTO selectRecipeByName(Connection con, String name) {
        AdminDTO recipe = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String query = prop.getProperty("selectRecipeByName");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            rset = pstmt.executeQuery();

            if (rset.next()) {
                recipe = new AdminDTO();
                recipe.setMenuName(rset.getString("name"));
                recipe.setIngredients(rset.getString("ingredients"));
                recipe.setMethod(rset.getString("method"));
                recipe.setTime(rset.getString("time"));
                recipe.setLevel(rset.getInt("level"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }

        return recipe;
    }

    public int updateRecipe(Connection con, AdminDTO recipe, String oldName) {
        int result = 0;
        PreparedStatement pstmt = null;
        String query = prop.getProperty("updateRecipe");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, recipe.getMenuName());       // 새 이름
            pstmt.setString(2, recipe.getIngredients());
            pstmt.setString(3, recipe.getMethod());
            pstmt.setString(4, recipe.getTime());
            pstmt.setInt(5, recipe.getLevel());
            pstmt.setString(6, oldName);                    // WHERE 절에 기존 이름 사용

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;

    }


    public int deleteRecipe(Connection con, String name) {
        int result = 0;
        PreparedStatement pstmt = null;

        // XML 파일에서 쿼리 읽어오기
        String query = prop.getProperty("deleteRecipe");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);  // 삭제할 레시피 이름

            result = pstmt.executeUpdate();  // 쿼리 실행
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);  // PreparedStatement 자원 해제
        }

        return result;
    }
}
