package frozen.admin.service;

import frozen.admin.dto.AdminDTO;
import frozen.admin.repository.AdminRepository;

import java.sql.Connection;
import java.util.List;

import static frozen.common.JDBCTemplate.*;

public class AdminService {

    private final AdminRepository ar = new AdminRepository();


    public int insertRecipe(AdminDTO recipe) {

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

    public List<AdminDTO> selectAllRecipes() {

        Connection con = getConnection();

        List<AdminDTO> recipes = ar.selectAllRecipes(con);

        close(con);

        return recipes;
    }
    public void updateRecipe() {
    }

    public void deleteRecipe() {
    }

}
