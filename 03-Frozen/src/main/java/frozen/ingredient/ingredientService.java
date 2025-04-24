
package frozen.ingredient;



import java.sql.Connection;

import static frozen.common.JDBCTemplate.*;

public class ingredientService {
    private final ingredientRepository ingredientRepository = new ingredientRepository();

    public void registIngredient(Ingredient ingredient) {

        Connection con = getConnection();
        int result = ingredientRepository.insertIngredient(con, ingredient);

        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
    }

    public void checkIngredient() {

        Connection con = getConnection();
        int result = ingredientRepository.checkIngredient(con);

        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
    }

    public void modifyIngredient(Ingredient modIng) {
        Connection con = getConnection();
        int result = ingredientRepository.updateMenu(con, modIng);

        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
    }
}
