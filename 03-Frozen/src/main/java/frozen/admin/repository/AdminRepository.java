package frozen.admin.repository;

import frozen.common.domain.Recipe;

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

    private List<Recipe> recipes;

    private Properties prop;

    public AdminRepository(){
        prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/frozen/mapper/AdminMapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public int insertRecipe(Connection con, Recipe recipe) {
        int result = 0;
        PreparedStatement pstmt = null;
        String query = prop.getProperty("insertRecipe");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, recipe.getName());
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


    public List<Recipe> selectAllRecipes(Connection con) {

        List<Recipe> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String query = prop.getProperty("selectRecipe");

        try {
            pstmt = con.prepareStatement(query);
            rset = pstmt.executeQuery();

            while (rset.next()) {
                Recipe recipe = new Recipe();
                recipe.setName(rset.getString("name"));
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

    public Recipe selectRecipeByName(Connection con, String name) {
        Recipe recipe = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String query = prop.getProperty("selectRecipeByName");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            rset = pstmt.executeQuery();

            if (rset.next()) {
                recipe = new Recipe();
                recipe.setName(rset.getString("name"));
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

    public int updateRecipe(Connection con, Recipe recipe, String oldName) {
        int result = 0;
        PreparedStatement pstmt = null;
        String query = prop.getProperty("updateRecipe");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, recipe.getName());
            pstmt.setString(2, recipe.getIngredients());
            pstmt.setString(3, recipe.getMethod());
            pstmt.setString(4, recipe.getTime());
            pstmt.setInt(5, recipe.getLevel());
            pstmt.setString(6, oldName);

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

        String query = prop.getProperty("deleteRecipe");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }
}
