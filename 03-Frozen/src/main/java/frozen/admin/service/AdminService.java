package frozen.admin.service;

import frozen.admin.repository.AdminRepository;
import frozen.common.domain.Recipe;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static frozen.common.JDBCTemplate.*;

public class AdminService {

    private final AdminRepository ar = new AdminRepository();


    public int insertRecipe(Recipe recipe) {

        Connection con = getConnection();

        int result = ar.insertRecipe(con, recipe);


        if (result > 0) {

            commit(con);
        } else {
            rollback(con);
        }

        close(con);

        return result;
    }

    public List<Recipe> selectAllRecipes() {

        Connection con = getConnection();

        List<Recipe> recipes = ar.selectAllRecipes(con);

        close(con);

        return recipes;
    }

    public Recipe getRecipeByName(String name) {
        try (Connection con = getConnection()) {
            return ar.selectRecipeByName(con, name);
        } catch (SQLException e) {
            e.printStackTrace();

            System.out.println("Error retrieving recipe by name: " + name);
            return null;
        }
    }

    public int updateRecipe(Recipe recipe, String oldName)  {
        Connection con = null;
        try {
            con = getConnection();
            con.setAutoCommit(false);

            Recipe existingRecipe = ar.selectRecipeByName(con, oldName);
            if (existingRecipe == null) {
                return -1;
            }

            int result = ar.updateRecipe(con, recipe, oldName);
            if (result > 0) {
                commit(con);
            } else {
                rollback(con);
            }

            return result;

        } catch (SQLException e) {
            e.printStackTrace();
            rollback(con);
            return 0;
        } finally {
            close(con);
        }
    }

    public int deleteRecipe(String name){
        Connection con = null;
        int result = 0;

        try {
            con = getConnection();
            con.setAutoCommit(false);

            result = ar.deleteRecipe(con, name);

            if (result > 0) {
                commit(con);
            } else {
                rollback(con);
            }
        } catch (SQLException e) {
            rollback(con);
            System.out.println("❌ 삭제 중 오류가 발생했습니다: " + e.getMessage());
        } finally {
            close(con);
        }

        return result;
    }
}
