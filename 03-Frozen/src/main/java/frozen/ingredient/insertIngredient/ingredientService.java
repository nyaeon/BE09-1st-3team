
package frozen.ingredient.insertIngredient;


import java.sql.Connection;

import static frozen.common.JDBCTemplate.*;

public class ingredientService {
    private final ingredientRepository ingredientRepository = new ingredientRepository();

    public void registIngredient(Ingredient ingredient) {
        System.out.println("[MenuService]registMenu:  menu ===> " + ingredient);

        Connection con = getConnection();
        int result = ingredientRepository.insertIngredient(con, ingredient);

        // 수행 결과에 따라서 Commit, Rollback 정해야한다.
        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
        System.out.println("[MenuService]registMenu:  End ===> ");
    }
}
