
package frozen.ingredient.service;

import frozen.common.domain.Ingredients;
import frozen.ingredient.repository.IngredientRepository;

import java.sql.Connection;
import java.time.LocalDate;

import static frozen.common.JDBCTemplate.*;

public class IngredientService {
    private final IngredientRepository ingredientRepository = new IngredientRepository();

    public void registIngredient(Ingredients ingredient,String userId) {

        Connection con = getConnection();
        int result = ingredientRepository.insertIngredient(con, ingredient,userId);

        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
    }

    public void checkIngredient(String userId) {

        Connection con = getConnection();
        int result = ingredientRepository.checkIngredient(con, userId);

        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
    }

    public void modifyIngredient(Ingredients modIng) {
        Connection con = getConnection();
        int result = ingredientRepository.updateIngredient(con, modIng);

        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
    }

    public Ingredients removeIngredient(String name, LocalDate date,String userId) {
        Connection con = getConnection();
        Ingredients ing = ingredientRepository.deleteIngredient(con, name, date,userId);
        if(ing == null){
            rollback(con);
            close(con);
            return null;
        }
        int result = ing.getAmount();
        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }
        close(con);
        return ing;
    }

}
